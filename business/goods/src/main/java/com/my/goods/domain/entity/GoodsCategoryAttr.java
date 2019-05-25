package com.my.goods.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategoryAttr {
    private Integer caId;

    private Integer categoryId;

    private Integer attrId;

    private Integer parentId;

    private Byte type;

    private Byte selected;

    private Byte status;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;
}