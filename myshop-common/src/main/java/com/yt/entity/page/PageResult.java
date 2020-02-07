package com.yt.entity.page;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PageResult
 * @Description 分页查询结果封装类
 * @createTime 2020年02月07日 11:04:00
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页显示的数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> conetent;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getConetent() {
        return conetent;
    }

    public void setConetent(List<?> conetent) {
        this.conetent = conetent;
    }
}
