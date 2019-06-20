package com.my.stock.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Stock {
    private Integer stockId;

    private Integer itemId;

    private Integer total;

    private Date createdTime;

    private Date updatedTime;

}