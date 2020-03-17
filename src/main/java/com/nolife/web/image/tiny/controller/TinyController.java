package com.nolife.web.image.tiny.controller;

import com.nolife.common.Result;
import com.nolife.web.image.tiny.service.TinyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *description 图片压缩controller
 *@author xierl
 *date 2020/3/15
 */
@Controller
public class TinyController {

    @Autowired
    private TinyService tinyService;

    /**
     * description 压缩图片接口，返回压缩后的数据
     * @param request req
     * @return Result
     *
     */
    @RequestMapping("/image/compress")
    @ResponseBody
    public Result tinyImage(HttpServletRequest request) throws Exception{
        List<Map<String,Object>> result = tinyService.tinyImage(request);
        return Result.success(result);
    }

    /**
     * description 图片压缩上传页面
     * @return String
     *
     */
    @RequestMapping("/compressPage")
    public String hello(){
        return "compressPage";
    }
}
