package com.my.include.common.vo;

import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/17 19:46
 */
@Data
public class PageReq<T> {
    private int pageNum;

    private int pageSize;

    private T req;
}
