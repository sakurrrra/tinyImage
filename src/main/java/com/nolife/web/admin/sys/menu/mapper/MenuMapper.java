package com.nolife.web.admin.sys.menu.mapper;

import com.nolife.web.admin.sys.menu.model.Menu;

import java.util.List;

/**
 *description 菜单mapper
 *@author xierl
 *date 2020/3/17
 */
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    // 获取列表分页
    List<Menu> getList();
}