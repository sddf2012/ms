package com.my.goods.domain.dto;

import com.my.goods.domain.entity.GoodsCategory;
import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 19:55
 */
@Data
public class GoodsCategoryAddDto {
    private GoodsCategory goodsCategory;

    /**
     * goodsCategory下的子节点的下一个排序值
     */
    private int childNextOrderValue;
}
