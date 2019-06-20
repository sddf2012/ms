package com.my.goods.domain.entity;

import com.my.include.common.domain.entity.BaseUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GoodsCategoryAttr extends BaseUpdated {
    private Integer caId;

    private Integer categoryId;

    private Integer attrId;

    private Integer parentId;

    private Integer type;

    private Integer selected;

    private Integer status;
}