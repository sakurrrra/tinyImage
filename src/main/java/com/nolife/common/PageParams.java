package com.nolife.common;

import java.io.Serializable;

/**
 *description 分页信息
 *@author xierl
 *date 2020/3/17
 */
public class PageParams implements Serializable {

    Integer pageSize;// 每页大小

    Integer pageNum;// 当前页码

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
