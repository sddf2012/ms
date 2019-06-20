package com.my.include.common.domain.vo;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/17 19:40
 */
@Data
public class PageResp<T> {
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;

    private int pages;

    private List<T> data;

    public PageResp() {
    }

    public PageResp(Page<T> page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
        this.data = page;
    }

    public <S> PageResp(Page<S> page, List<T> data) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
        this.data = data;
    }

    public <S> PageResp(Page<S> page, Function<S, T> function) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.total = page.getTotal();
        this.pages = page.getPages();
        this.data = page.stream().map(function).collect(Collectors.toList());
    }
}
