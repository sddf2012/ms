package com.my.include.common.constants.enums;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 19:14
 */
public enum LeafEnum {
    /**
     *
     */
    LEAF(1, "是叶子节点"),
    NOT_LEAF(0, "不是叶子节点");

    public int code;
    public String desc;

    LeafEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static boolean isLeaf(int code) {
        return LEAF.code == code;
    }
}
