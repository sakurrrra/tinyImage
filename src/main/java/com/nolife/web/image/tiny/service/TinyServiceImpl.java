package com.nolife.web.image.tiny.service;

import com.nolife.utils.CompressUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *description 图片压缩service
 *@author xierl
 *date 2020/3/15
 */
@Service
public class TinyServiceImpl implements TinyService {

    /**
     * description 图片压缩-支持多图片压缩
     * @param request req
     * @return List<Map<String, Object>>
     * @Exception Exception e
     * 
     */
    @Override
    public List<Map<String, Object>> tinyImage(HttpServletRequest request) throws Exception {
        return CompressUtil.compress(request);
    }
}
