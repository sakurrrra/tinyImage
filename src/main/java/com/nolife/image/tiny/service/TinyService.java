package com.nolife.image.tiny.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TinyService {
    List<Map<String,Object>> tinyImage(HttpServletRequest request) throws Exception;
}
