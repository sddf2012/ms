package com.my.goods.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsSku {
    private Integer skuId;

    private Integer caId;

    private Integer spuId;

    private String skuCode;

    private String skuName;

    private String description;

    private BigDecimal retailPrice;

    private Byte status;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;
}