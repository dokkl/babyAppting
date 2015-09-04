package com.hoon.appting.web;

import com.hoon.appting.dto.MemberDto;
import com.hoon.appting.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hoon on 2015-08-12.
 */
@Controller
public class ConnectController {
    @Autowired
    private ConnectService connectService;

    @RequestMapping(value = "/connectedMembers", method = RequestMethod.GET)
    @ResponseBody
    public List<MemberDto> getConnectedMembers(@RequestParam String myEmail) {
        return connectService.getConnectedMembers(myEmail);
    }
}
