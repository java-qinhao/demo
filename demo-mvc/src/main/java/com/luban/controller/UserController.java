package com.luban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        System.out.println(111111);
        Map map=new HashMap();
        map.put("key","value");
        return map.toString();
    }
}
