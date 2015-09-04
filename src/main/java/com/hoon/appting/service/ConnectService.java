package com.hoon.appting.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.dto.Sex;
import com.hoon.appting.entity.Connect;
import com.hoon.appting.entity.Member;
import com.hoon.appting.entity.QConnect;
import com.hoon.appting.repository.ConnectRepository;
import com.mysema.query.jpa.impl.JPAQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hoon on 2015-08-11.
 */
@Service
public class ConnectService {
    private static final Logger log = LoggerFactory.getLogger("ConnectService");

    @Autowired
    private ConnectRepository connectRepository;

    @Autowired MemberService memberService;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void executeTodayConnect(Member myMember) {
        //연결조건
        //오늘 연결아직 안된사람
        //나랑 다른 성
        //비슨한 나이 +-4살
        //같은지역
        //하루한번
        Sex sex = myMember.getSex();
        int age = myMember.getAge();
        String area1 = myMember.getAddress1();

        List<Member> targetMembers = memberService.findTargetMember(sex, age, area1);
        if (targetMembers.size() < 1 ) {
            log.debug("=====연결할 대상이 없습니다.======");
            return;
        }

        Connect connect = new Connect();
        connect.setMyMember(myMember);
        connect.setTargetMember(targetMembers.get(0));
        Date today = new Date();
        connect.setConnectDay(today);
        connect.setCreateAt(today);
        connect.setUpdateAt(today);
        save(connect);

        Connect connect2 = new Connect();
        connect2.setMyMember(targetMembers.get(0));
        connect2.setTargetMember(myMember);
        connect2.setConnectDay(today);
        connect2.setCreateAt(today);
        connect2.setUpdateAt(today);
        save(connect2);

        myMember.setLastConnectDate(today);
        if (myMember.getLastConnectCount() == null) {
            myMember.setLastConnectCount(1);
        } else {
            myMember.setLastConnectCount(myMember.getLastConnectCount() + 1);
        }

        Member targetMember = memberService.findMemberByEmail(targetMembers.get(0).getMail());
        targetMember.setLastConnectDate(today);
        if (targetMember.getLastConnectCount() == null) {
            targetMember.setLastConnectCount(1);
        } else {
            targetMember.setLastConnectCount(targetMember.getLastConnectCount() + 1);
        }
    }

    private void save(Connect connect) {
        connectRepository.save(connect);
    }

    public List<MemberDto> getConnectedMembers(String myEmail) {
        QConnect qConnect = QConnect.connect;
        JPAQuery query = new JPAQuery(entityManager);
        List<Connect> connects = query.from(qConnect)
                .where(qConnect.myMember.mail.eq(myEmail))
                .orderBy(qConnect.connectDay.desc()).list(qConnect);

        Function<Connect, Member> memberFilter = new Function<Connect, Member>() {
            public Member apply(Connect connect) {
                return connect.getTargetMember();
            }
        };

        List<Member> connectedMembers = Lists.transform(connects, memberFilter);

        List<MemberDto> connectedMemberDtos = new ArrayList<>();
        for (Member member : connectedMembers) {
            MemberDto memberDto = new MemberDto();
            memberService.convertMemberToMemberDto(member, memberDto);
            connectedMemberDtos.add(memberDto);
        }
        return connectedMemberDtos;
    }
}
