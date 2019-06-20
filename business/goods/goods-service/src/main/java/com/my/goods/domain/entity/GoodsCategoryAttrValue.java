package com.my.goods.domain.entity;

import com.my.include.common.domain.entity.BaseUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GoodsCategoryAttrValue extends BaseUpdated {
    private Integer cavId;

    private Integer caId;

    private String value;

    private String description;

    private Integer status;
}