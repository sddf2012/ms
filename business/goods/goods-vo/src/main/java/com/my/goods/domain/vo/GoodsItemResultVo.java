package com.my.goods.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 17:46
 */
@Data
public class GoodsItemResultVo {
    private Integer itemId;

    private Integer caId;

    private String itemCode;

    private String itemName;

    private String description;

    private BigDecimal price;

    private String picture;

    private Integer stock;

    public GoodsItemResultVo() {
        stock=0;
    }
}
