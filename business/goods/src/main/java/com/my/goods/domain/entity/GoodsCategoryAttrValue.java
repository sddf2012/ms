package com.my.goods.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategoryAttrValue {
    private Integer cavId;

    private Integer caId;

    private String value;

    private String description;

    private Byte status;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;

}