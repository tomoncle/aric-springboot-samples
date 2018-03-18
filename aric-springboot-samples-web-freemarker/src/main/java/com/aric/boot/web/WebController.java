package com.aric.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liyuanjun on 16-10-9.
 */
@Controller
public class WebController {

    @RequestMapping("/")
    String  index(){
        System.out.println("index...");
        return "index";
    }


    @RequestMapping("/hello")
    String welcome(){
        System.out.println("hello...");
        return "hello";
    }

}
