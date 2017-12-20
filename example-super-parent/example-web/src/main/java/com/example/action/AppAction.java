package com.example.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author maorui.wang
 * @date 2017年12月18日
 * @version 1.0
 */
@Controller
public class AppAction {

	 /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(AppAction.class);
    
    @GetMapping("/helloMrwang")
    @ResponseBody
    public String helloMrwang(){
    	return "Hello Mr.wang";
    }
}
