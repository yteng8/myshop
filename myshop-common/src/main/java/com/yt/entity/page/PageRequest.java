package com.yt.entity.page;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PageRequest
 * @Description 分页查询请求类
 * @createTime 2020年02月07日 11:02:00
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页显示的数量
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
