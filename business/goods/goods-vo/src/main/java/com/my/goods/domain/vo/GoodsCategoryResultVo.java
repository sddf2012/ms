package com.my.goods.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:12
 */
@Data
public class GoodsCategoryResultVo {
    private Integer categoryId;

    private String categoryCode;

    private String categoryName;

    private Integer parentId;

    private Integer orderValue;

    private Integer level;

    private Boolean isLeaf;

    private Date createdTime;

    private Date updatedTime;

    private String createdUser;

    private String updatedUser;

    private List<GoodsCategoryResultVo> children;
}
