package com.nolife.image.tiny.controller;

import com.nolife.common.Result;
import com.nolife.image.tiny.service.TinyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/compressPage")
    public String hello(){
        return "compressPage";
    }
}
