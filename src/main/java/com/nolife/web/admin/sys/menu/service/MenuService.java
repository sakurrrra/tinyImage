package com.nolife.web.admin.sys.menu.service;

import com.nolife.common.PageParams;
import com.nolife.web.admin.sys.menu.model.Menu;

import java.util.Map;

/**
 *description 菜单interface
 *@author xierl
 *date 2020/3/17
 */
public interface MenuService {

    // 新增
    int insert(Menu menu);

    //修改
    int update(Menu menu);

    //删除
    int delete(Integer menuId);

    //获取列表
    Map<String, Object> getList(PageParams pageParams);
}
