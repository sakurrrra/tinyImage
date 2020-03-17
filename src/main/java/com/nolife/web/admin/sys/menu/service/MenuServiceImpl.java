package com.nolife.web.admin.sys.menu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nolife.common.PageParams;
import com.nolife.web.admin.sys.menu.mapper.MenuMapper;
import com.nolife.web.admin.sys.menu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *description 菜单service
 *@author xierl
 *date 2020/3/17
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public int insert(Menu menu) {
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int delete(Integer menuId) {
        return menuMapper.deleteByPrimaryKey(menuId);
    }

    /**
     * description 获取列表-分页
     * @param pageParams 分页
     * @return Map<String, Object>
     *
     */
    @Override
    public Map<String, Object> getList(PageParams pageParams) {
        Map<String, Object> map = new HashMap<>();
        if (pageParams.getPageSize() != null && pageParams.getPageNum() != null) {
            PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        }
        List<Menu> list = menuMapper.getList();
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        map.put("data", list);
        map.put("total", total);
        return map;
    }

}
