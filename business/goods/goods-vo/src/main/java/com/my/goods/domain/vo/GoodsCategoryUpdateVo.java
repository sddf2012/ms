package com.my.goods.domain.vo;

import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 19:49
 */
@Data
public class GoodsCategoryUpdateVo {
    private Integer categoryId;

    private String categoryCode;

    private String categoryName;

    private Integer parentId;

    private Integer orderValue;

    private String updatedUser;
}
