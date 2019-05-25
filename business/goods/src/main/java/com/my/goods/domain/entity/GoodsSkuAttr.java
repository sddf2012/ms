package com.my.goods.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsSkuAttr {
    private Integer saId;

    private Integer skuId;

    private String attrCode;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;
}