package com.my.goods.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 14:49
 */
@Data
public class GoodsCategoryAttrValueResultVo {
    private Integer cavId;

    private Integer caId;

    private String value;

    private String description;

    private Date createdTime;

    private String createdUser;

    private Date updatedUser;

    private Date updatedTime;
}
