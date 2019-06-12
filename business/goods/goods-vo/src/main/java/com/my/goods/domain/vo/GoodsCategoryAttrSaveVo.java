package com.my.goods.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/11 17:51
 */
@Data
public class GoodsCategoryAttrSaveVo {
    private Integer caId;

    private Integer categoryId;

    private String attrName;

    private Integer attrId;

    @NotNull(message="属性类型不能为空")
    private Integer type;

    @NotNull(message="是否查询属性不能为空")
    private Integer selected;

    private String operator;
}
