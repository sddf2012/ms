package com.my.goods.utils;

import com.my.goods.domain.entity.GoodsCategory;
import com.my.include.common.constants.enums.LeafEnum;
import com.my.include.common.constants.enums.StatusEnum;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/29 14:43
 */
public class GoodsCategoryUtils {
    private static class InnerVirtualRoot {
        static GoodsCategory root = new GoodsCategory();

        static {
            root.setCategoryId(0);
            root.setLevel(0);
            root.setIsLeaf(LeafEnum.NOT_LEAF.code);
            root.setParentId(null);
            root.setStatus(StatusEnum.VALID.code);
        }
    }

    /**
     * 获取虚拟根节点
     *
     * @return 虚拟根节点
     */
    public static GoodsCategory virtualRoot() {
        return InnerVirtualRoot.root;
    }
}
