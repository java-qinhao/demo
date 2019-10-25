package com.luban.controller;

import com.luban.config.Resubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/sub")
    @ResponseBody
    @Resubmit()
    public String sub(@RequestParam("name") String name,String age){
        System.out.println("name="+name+" age="+age);
        return "成功";
    }
}
