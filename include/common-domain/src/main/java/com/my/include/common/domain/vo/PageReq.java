package com.my.include.common.domain.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/17 19:46
 */
@Data
public class PageReq {
    @Range(min = 1, message = "页数最小值为1")
    protected int pageNum;

    @Range(min = 1, message = "每页大小最小值为1")
    protected int pageSize;
}
