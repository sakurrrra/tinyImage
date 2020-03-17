package com.nolife.web.admin.sys.menu.controller;

import com.nolife.common.PageParams;
import com.nolife.common.Result;
import com.nolife.web.admin.sys.menu.model.Menu;
import com.nolife.web.admin.sys.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *description 菜单controller
 *@author xierl
 *date 2020/3/17
 */
@RequestMapping("/sysMenu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * description 获取菜单列表--分页
     * @param pageParams 分页
     * @return Reslut
     *
     */
    @RequestMapping("/getList")
    public Result getList(PageParams pageParams){
        Map<String,Object> result = menuService.getList(pageParams);
        return Result.success(result);
    }

    @RequestMapping("/insert")
    public Result insert(Menu menu){
        menuService.insert(menu);
        return Result.success();
    }

    @RequestMapping("/update")
    public Result update(Menu menu){
        menuService.update(menu);
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result delete(Integer menuId){
        menuService.delete(menuId);
        return Result.success();
    }

}
