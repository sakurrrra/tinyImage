package com.nolife.image.tiny.service;

import com.nolife.utils.CompressUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class TinyServiceImpl implements TinyService {

    @Override
    public List<Map<String, Object>> tinyImage(HttpServletRequest request) throws Exception {
        return CompressUtil.compress(request);
    }
}
