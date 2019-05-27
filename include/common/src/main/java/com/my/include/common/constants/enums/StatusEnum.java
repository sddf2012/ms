package com.my.include.common.constants.enums;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 19:12
 */
public enum StatusEnum {
    /**
     *
     */
    UN_VALID(0, "无效的"),
    VALID(1, "有效的");

    public int code;
    public String desc;

    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
