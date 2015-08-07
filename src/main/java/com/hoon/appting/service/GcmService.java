package com.hoon.appting.service;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.hoon.appting.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoon on 2015-07-29.
 */
@Service
public class GcmService {
    private static final Logger log = LoggerFactory.getLogger(GcmService.class);
    private static final String SERVER_API_KEY = "AIzaSyBFU5lHh3mAGN5-WxWcakC_goKaa3KVzdE";

    @Autowired
    private MemberService memberService;

    public String getTargetId(String email) {
        MemberDto memberDto = memberService.findMember(email);
        return memberDto.getDeviceRegId();
    }

    public List<String> getTargetIdAllList() {
        List<MemberDto> memberDtos = memberService.getAllMembers();

        // when
        Function<MemberDto, String> regIdFilter = new Function<MemberDto, String>() {
            public String apply(MemberDto memberDto) {
                return memberDto.getDeviceRegId();
            }
        };

        List<String> regIdList = Lists.transform(memberDtos, regIdFilter);
        return regIdList;
    }


    public void sendPushMessage(String msg, List<String> regIdList) {
        Sender sender = new Sender(SERVER_API_KEY); // 서버 API Key 입력
        //String regId = "APA91bEx-rGTeQm_48-62cUoW_BZJA71u2dIAasMys3mszPZhlBF8NSbwFqY_sFs4wdvYJuhus1Pjr9IWQlfc8QMfNV5WIIlfIjcxUrVgSf8rdxmSMjO7A7DPYnQTe9gV4izMdl023ZWm_i7bt3OAD9c_rSx-_Q-J1LI1SaL-HynKlbtHSaMdU0"; // 단말기 RegID 입력

        String messageKr = null;
        messageKr = msg;
        /*try {
            //msg = "hello! 안녕하세요? 반가워요. ㅎㅎ \n 어디계세요?";
            messageKr = URLEncoder.encode(msg, "euc-kr");
        } catch (UnsupportedEncodingException e) {
            log.error("sendPushMessage UnsupportedEncodingException ", e);
        }*/
        Message message = new Message.Builder().addData("msg", messageKr)
                .build();
        //List<String> regIdList = new ArrayList<String>();
        //regIdList.add(regId);
        MulticastResult multiResult;
        try {
            multiResult = sender.send(message, regIdList, 5);
            if (multiResult != null) {
                List<Result> resultList = multiResult.getResults();
                for (Result result : resultList) {
                    log.debug("result.getMessageId() : " + result.getMessageId());
                    log.debug("result.getCanonicalRegistrationId() : " + result.getCanonicalRegistrationId());
                }
            }
        } catch (IOException e) {
            log.error("sendPushMessage IOException ", e);
        }
    }
}
