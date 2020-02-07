package com.yt.util;

import com.github.pagehelper.PageInfo;
import com.yt.entity.page.PageRequest;
import com.yt.entity.page.PageResult;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PageUtils
 * @Description 将分页信息封装到统一接口
 * @createTime 2020年02月07日 11:32:00
 */
public class PageUtils {

    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setConetent(pageInfo.getList());
        return pageResult;
    }
}
