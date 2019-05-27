package com.my.include.common.constants.enums;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 16:07
 */
public enum YesNoEnum {
    /**
     *
     */
    YES(1, "是"),
    NO(0, "否");

    public int code;
    public String desc;

    YesNoEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static boolean isYes(int code) {
        return code == YES.code;
    }
}
