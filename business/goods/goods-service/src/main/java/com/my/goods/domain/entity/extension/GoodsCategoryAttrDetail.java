package com.my.goods.domain.entity.extension;

import com.my.goods.domain.entity.GoodsCategoryAttr;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 9:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GoodsCategoryAttrDetail extends GoodsCategoryAttr {
    private String categoryName;

    private String attrName;
}
