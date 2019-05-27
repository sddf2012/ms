package com.my.include.common.constants.enums;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:32
 */
public enum ResultEnum {
    /**
     * success
     */
    SUCCESS("00000", "成功!"),
    ERROR("00001", "失败!"),

    REQ_PARAM_NULL("00002", "请求参数不能为空"),

    /**
     * 商品模块
     */
    GOODS_ADD_CATEGORY("10001", "新增分类失败{}"),

    GOODS_UPDATE_CATEGORY("10005", "更新分类失败{}")
    ;

    /**
     * 返回值代码
     */
    public String code;

    /**
     * 返回值消息
     */
    public String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
