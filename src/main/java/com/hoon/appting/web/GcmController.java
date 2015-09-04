package com.hoon.appting.web;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.service.GcmService;
import com.hoon.appting.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-05-05.
 */
@Controller
public class GcmController {
    private static final Logger log = LoggerFactory.getLogger("GcmController");

    @Autowired
    private GcmService gcmService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/pushMessage", method = RequestMethod.GET)
    public ModelAndView pushMessageView() {
        ModelAndView mv = new ModelAndView("pushMessage");
        initForMemberList(mv);
        return mv;
    }

    @RequestMapping(value = "/pushMessage", method = RequestMethod.POST)
    public ModelAndView pushMessage(@RequestParam String msg, @RequestParam List<String> checkedList) {
        log.debug("msg : " + msg);
        log.debug("checkedList size : " + checkedList.size());
        for (String mail : checkedList) {
            log.debug("mail : " + mail);
        }
        ModelAndView mv = new ModelAndView("pushMessage");
        initForMemberList(mv);
        if (StringUtils.isEmpty(msg)) {
            return mv;
        }

        List<String> regIds = new ArrayList<>();
        for (String mail : checkedList) {
            String targetId = gcmService.getTargetId(mail);
            regIds.add(targetId);
        }
        gcmService.sendPushMessage(msg, regIds);

        return mv;
    }

    private void initForMemberList(ModelAndView mv) {
        List<MemberDto> memberList = memberService.getAllMembers();
        log.debug("memberList size : " + memberList.size());

        mv.addObject("memberList", memberList);
    }

    @RequestMapping(value = "/pushMessageTest")
    public String pushMessageTest() {
        String msg = "hello! 안녕하세요? 반가워요. ㅎㅎ \n 어디계세요?";
        String targetIds = gcmService.getTargetId("dokkl@naver.com");
        List<String> regIds = new ArrayList<>();
        regIds.add(targetIds);
        log.debug("regIds : " + regIds.get(0));
        gcmService.sendPushMessage(msg, regIds);

        return "pushMessageTest";
    }
}
