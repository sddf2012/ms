package com.my.goods.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsAttr extends BaseUpdated{
    private Integer attrId;

    private String attrCode;

    private String attrName;

    private String description;

}