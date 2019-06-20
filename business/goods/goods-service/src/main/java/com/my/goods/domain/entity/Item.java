package com.my.goods.domain.entity;

import com.my.include.common.domain.entity.BaseUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Item extends BaseUpdated {
    private Integer itemId;

    private Integer caId;

    private String itemCode;

    private String itemName;

    private String description;

    private BigDecimal price;

    private String picture;

    private Integer status;
}