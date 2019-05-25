package com.my.goods.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsAttr {
    private Integer attrId;

    private String attrCode;

    private String attrName;

    private String description;

    private Date createdTime;

    private Date updatedTime;
}