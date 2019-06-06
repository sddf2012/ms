package com.my.goods.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/4 13:58
 */
@Data
public class GoodsCategorySaveVo {
    private Integer categoryId;

    @NotNull(message = "parentId不能为空!")
    private Integer parentId;

    @NotNull(message = "categoryCode不能为空!")
    private String categoryCode;

    @NotNull(message = "categoryName不能为空!")
    private String categoryName;

    @NotNull(message = "operator不能为空!")
    private String operator;
}
