package com.hoon.appting.web;

import com.hoon.appting.dto.Sex;
import com.hoon.appting.entity.Member;
import com.hoon.appting.repository.MemberRepository;
import com.hoon.appting.service.ConnectService;
import com.hoon.appting.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by hoon on 2015-07-25.
 */
@Controller
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ConnectService connectService;

    @RequestMapping("/")
    public String index(Model model) {
        long allMemberCount = memberService.getAllMemberCount();
        long todayRegistedMemberCount = memberService.getTodayRegistedMemberCount();

        model.addAttribute("allMemberCount", allMemberCount);
        model.addAttribute("todayRegistedMemberCount", todayRegistedMemberCount);
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        log.debug(">>>> ㅎㅎ hello called");
        model.addAttribute("name", "애봉이의 스프링부트 시작!!");
        return "hello";
    }

    @RequestMapping("/testConnect")
    public String testConnect() {
       /* String sex = "M";
        int age = 38;
        String area1 = "경기";
        List<Member> list = memberService.findTargetMember(sex, age, area1);
        log.debug("연결대상건수 >>>> list szie : " + list.size());*/

        Member member = memberService.findMemberByEmail("dokkl@naver.com");
        connectService.executeTodayConnect(member);
        return "hello";
    }

    @RequestMapping("/createMember")
    public String createDefaultMember() {
        Member member2 = new Member();
        member2.setMail("juju@naver.com");
        member2.setPassword("123456");
        member2.setName("김봉숙");
        member2.setSex(Sex.F);
        member2.setPhoneAuth("01067881234");
        member2.setBirthday("19801107");
        member2.setDeviceRegId("APA91bEO2-GKYZ2igNBNGz5hdfYuCxUEiDez7rG1AVpy3mkzomYr1bTidBvLSOFmqWupsOpOqZaHahROKZJtmpIFvuQz1iMk7A3PqeYqmECr6yUb7JWNtO-UMX4y87LPqhS1fuGSC1GW3-KSi1rBOaMu8Z3OQz6x6A");
        member2.setPhoneAuth("349085");
        member2.setAge(35);
        member2.setAddress1("서울");
        member2.setJob("IT.인터넷");
        member2.setHeight("170");
        member2.setReligion("불교");
        member2.setHobby("운동.스포츠,TV.인터넷,");
        member2.setImage1("smile_1438956302989.jpg");
        member2.setImage2("smile_1438956339800.jpg");
        member2.setBloodType("B형");
        member2.setBodyType("뚱뚱한");
        member2.setCharacterType("지적인, 친철한");
        member2.setCreateAt(new Date());
        member2.setUpdateAt(new Date());
        member2.setNickName("꾸미");

        memberRepository.save(member2);
        return "hello";
    }


}
