package com.my.goods.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategory {
    private Integer categoryId;

    private String categoryCode;

    private String categoryName;

    private Integer parentId;

    private Integer orderValue;

    private Integer level;

    private Integer isLeaf;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;
}