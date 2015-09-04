package com.hoon.appting.service;


import com.hoon.appting.dto.ApiDataModel;
import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.dto.Sex;
import com.hoon.appting.entity.Member;
import com.hoon.appting.entity.QConnect;
import com.hoon.appting.entity.QMember;
import com.hoon.appting.repository.MemberRepository;
import com.hoon.appting.util.CommonUtil;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hoon on 2015-04-26.
 */
@Service
public class MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    @Autowired
    private MemberRepository memberRepository;

    public void addMember(MemberDto memberDto) {
        Member member = new Member();
        convertMemberDtoToMember(memberDto, member);
        memberRepository.save(member);
    }

    private void convertMemberDtoToMember(MemberDto memberDto, Member member) {
        member.setMail(memberDto.getMail());
        member.setPassword(memberDto.getPassword());
        member.setName(memberDto.getName());
        member.setSex(memberDto.getSex());
        member.setPhone(memberDto.getPhone());
        member.setBirthday(memberDto.getBirthday());
        member.setDeviceRegId(memberDto.getDeviceRegId());
        member.setPhoneAuth(memberDto.getPhoneAuth());
        member.setAge(memberDto.getAge());
        member.setKakaoId(memberDto.getKakaoId());
        member.setAddress1(memberDto.getAddress1());
        member.setAddress2(memberDto.getAddress2());
        member.setCreateAt(memberDto.getCreateAt());
        member.setUpdateAt(memberDto.getUpdateAt());

        member.setNickName(memberDto.getNickName());
        member.setJob(memberDto.getJob());
        member.setHobby(memberDto.getHobby());
        member.setCharacterType(memberDto.getCharacter());
        member.setHeight(memberDto.getHeight());
        member.setBodyType(memberDto.getBodyType());
        member.setReligion(memberDto.getReligion());
        member.setBloodType(memberDto.getBloodType());

        member.setSelfIntroduction(memberDto.getSelfIntroduction());
        member.setIdealType(memberDto.getIdealType());
        member.setMyAppeal(memberDto.getMyAppeal());

        member.setImage1(memberDto.getImage1());
        member.setImage2(memberDto.getImage2());
        member.setImage3(memberDto.getImage3());
        member.setImage4(memberDto.getImage4());
    }

    /**
     * 메일로 멤버 찾기
     * @param mail
     * @return
     */
    public MemberDto findMember(String mail) {
        Member member = memberRepository.findByMail(mail);
        MemberDto memberDto = new MemberDto();

        if (member == null) {
            return null;
        }

        convertMemberToMemberDto(member, memberDto);
        return memberDto;
    }

    public ApiDataModel<MemberDto> getMemberAtApi(String mail) {
        ApiDataModel<MemberDto> apiDataModel = new ApiDataModel<MemberDto>();
        MemberDto memberDto = findMember(mail);
        if (memberDto == null) {
            apiDataModel.setApiSuccess(false);
            apiDataModel.setApiMessage("등록된회원이 아닙니다.");
            return apiDataModel;
        }
        if ("null".equals(memberDto.getPhone())) {
            System.out.println("null string");
        }
        System.out.println("getPhone [" + memberDto.getPhone() + "]");
        System.out.println("getSelfIntroduction : " + memberDto.getSelfIntroduction());
        System.out.println("getIdealType : " + memberDto.getIdealType());
        System.out.println("getMyAppeal : " + memberDto.getMyAppeal());
        apiDataModel.setDto(memberDto);
        return apiDataModel;
    }

    public List<MemberDto> getAllMembers() {
        List<MemberDto> list = new ArrayList<MemberDto>();
        List<Member> memberList = memberRepository.findAll();
        for (Member member : memberList) {
            MemberDto memberDto = new MemberDto();
            convertMemberToMemberDto(member, memberDto);
            list.add(memberDto);
        }
        return list;
    }

    public void convertMemberToMemberDto(Member member, MemberDto memberDto) {
        memberDto.setMail(member.getMail());
        memberDto.setPassword(member.getPassword());
        memberDto.setName(member.getName());
        memberDto.setSex(member.getSex());
        memberDto.setPhone(member.getPhone());
        memberDto.setBirthday(member.getBirthday());
        memberDto.setDeviceRegId(member.getDeviceRegId());
        memberDto.setPhoneAuth(member.getPhoneAuth());
        //memberDto.setAge(member.getAge());
        memberDto.setKakaoId(member.getKakaoId());
        memberDto.setAddress1(member.getAddress1());
        memberDto.setAddress2(member.getAddress2());
        memberDto.setCreateAt(member.getCreateAt());
        memberDto.setUpdateAt(member.getUpdateAt());

        memberDto.setNickName(member.getNickName());
        memberDto.setJob(member.getJob());
        memberDto.setHobby(member.getHobby());
        memberDto.setCharacter(member.getCharacterType());
        memberDto.setHeight(member.getHeight());
        memberDto.setBodyType(member.getBodyType());
        memberDto.setReligion(member.getReligion());
        memberDto.setBloodType(member.getBloodType());

        memberDto.setSelfIntroduction(member.getSelfIntroduction());
        memberDto.setIdealType(member.getIdealType());
        memberDto.setMyAppeal(member.getMyAppeal());

        memberDto.setImage1(member.getImage1());
        memberDto.setImage2(member.getImage2());
        memberDto.setImage3(member.getImage3());
        memberDto.setImage4(member.getImage4());

    }

    public MemberDto updateMember(MemberDto memberDto) {
        log.debug("메일 : " + memberDto.getMail());
        log.debug("getBirthday : " + memberDto.getBirthday());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setName(memberDto.getName());
        member.setBirthday(memberDto.getBirthday());
        member.setSex(memberDto.getSex());
        member.setPhone(memberDto.getPhone());
        member.setPhoneAuth(memberDto.getPhoneAuth());
        member.setAge(CommonUtil.getAge(memberDto.getBirthday()));

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto addDeviceRegId(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setDeviceRegId(memberDto.getDeviceRegId());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberBasicProfile(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setNickName(memberDto.getNickName());
        member.setAddress1(memberDto.getAddress1());
        member.setAddress2(memberDto.getAddress2());
        member.setBloodType(memberDto.getBloodType());
        member.setReligion(memberDto.getReligion());
        member.setJob(memberDto.getJob());

        member.setHobby(memberDto.getHobby());
        member.setCharacterType(memberDto.getCharacter());
        member.setHeight(memberDto.getHeight());
        member.setBodyType(memberDto.getBodyType());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberIntroduction(MemberDto memberDto) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());
        member.setSelfIntroduction(memberDto.getSelfIntroduction());
        member.setHobby(memberDto.getHobby());
        member.setMyAppeal(memberDto.getMyAppeal());
        member.setIdealType(memberDto.getIdealType());

        memberRepository.save(member);
        return memberDto;
    }

    public MemberDto updateMemberProfileImage(MemberDto memberDto, String imageNumber) {
        System.out.println("메일 : " + memberDto.getMail());
        Member member = memberRepository.findByMail(memberDto.getMail());

        if (imageNumber.equals("1")) {
            member.setImage1(memberDto.getImage1());
        } else if (imageNumber.equals("2")) {
            member.setImage2(memberDto.getImage2());
        } else if (imageNumber.equals("3")) {
            member.setImage3(memberDto.getImage3());
        } else if (imageNumber.equals("4")) {
            member.setImage4(memberDto.getImage4());
        }

        memberRepository.save(member);
        return memberDto;
    }

    public List<MemberDto> getMembers(Sex sex) {
        List<MemberDto> list = new ArrayList<MemberDto>();
        List<Member> memberList = memberRepository.findBySex(sex);
        for (Member member : memberList) {
            MemberDto memberDto = new MemberDto();
            convertMemberToMemberDto(member, memberDto);
            list.add(memberDto);
        }
        return list;
    }

    /**
     * 전체 회원수 가져오기
     * @return
     */
    public long getAllMemberCount() {
        return memberRepository.count();
    }

    @Autowired
    private EntityManager entityManager;

    /**
     * 오늘 가입한 회원수 가져오기
     * @return
     */
    @Transactional
    public long getTodayRegistedMemberCount() {
        Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);

        Date today2 = new Date();
        today2.setHours(23);
        today2.setMinutes(59);
        today2.setSeconds(59);

        QMember qMember = QMember.member;
        Predicate predicate = qMember.createAt.between(today, today2);
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(qMember).where(predicate).count();
    }

    public List<Member> findTargetMember(Sex sex, int age, String area1) {
        QMember qMember = QMember.member;
        Predicate predicate = qMember.sex.ne(sex)
                                            .and(qMember.age.between(age-4, age+4))
                                            .and(qMember.address1.eq(area1))
                                            .and(qMember.lastConnectCount.isNull().or(qMember.lastConnectCount.lt(Integer.valueOf(1))))
                .and(qMember.lastConnectDate.before(new Date()).or(qMember.lastConnectDate.isNull()));
        JPAQuery query = new JPAQuery(entityManager);
        List<Member> targetList = query.from(qMember).where(predicate).list(qMember);
        return targetList;
    }

    public Member findMemberByEmail(String email) {
        return memberRepository.findByMail(email);
    }
}
