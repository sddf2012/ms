package com.my.goods.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 19:49
 */
@Data
public class GoodsCategoryUpdateVo {
    @NotNull(message = "分类id不能为空")
    private Integer categoryId;

    private String categoryCode;

    private String categoryName;

    private Integer orderValue;

    private String updatedUser;
}
