package com.nolife.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
