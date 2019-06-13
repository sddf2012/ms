package com.my.goods.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 16:49
 */
@Data
public class GoodsCategoryAttrValueSaveVo {
    private Integer cavId;

    @NotNull(message = "分类id不能为空")
    private Integer caId;

    @NotEmpty(message = "属性值不能为空")
    private String value;

    private String description;

    private String operator;
}
