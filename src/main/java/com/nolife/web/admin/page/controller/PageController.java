package com.nolife.web.admin.page.controller;

import com.nolife.utils.IpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *description 页面controller
 *@author xierl
 *date 2020/3/15
 */
@Controller
public class PageController {

    /**
     * description admin -主页
     * @return String
     *
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public void hello(HttpServletRequest request){
        System.out.println("sss");
        System.out.println(IpUtil.getIpAddr(request));
    }
}
