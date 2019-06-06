package com.my.goods.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 14:27
 */
@Data
public class GoodsCategoryAttrResultVo {
    private Integer caId;

    private Integer categoryId;

    private Integer attrId;

    private Integer parentId;

    private Integer type;

    private Integer selected;

    private String categoryName;

    private String attrName;

    private Date createdTime;

    private String createdUser;

    private Date updatedUser;

    private Date updatedTime;
}
