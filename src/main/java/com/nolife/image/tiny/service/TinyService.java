package com.nolife.image.tiny.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *description 图片压缩interface
 *@author xierl
 *date 2020/3/15
 */
public interface TinyService {

    // 图片压缩-多张图片
    List<Map<String,Object>> tinyImage(HttpServletRequest request) throws Exception;
}
