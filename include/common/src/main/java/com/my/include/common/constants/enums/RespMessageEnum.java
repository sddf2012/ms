package com.my.include.common.constants.enums;

import java.text.MessageFormat;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:32
 */
public enum RespMessageEnum {
    /**
     * success
     */
    SUCCESS("00000", "成功!"),
    ERROR("00001", "失败!"),

    REQ_PARAM_NULL("00002", "请求参数不能为空!"),
    REQ_PARAM_VALIDATE("00003", "请求参数异常!"),

    /**
     * 商品模块
     */
    GOODS_CATEGORY_SAVE_1("10001", "保存分类失败:根据父节点id:{0} 未找到相应的分类!"),
    GOODS_CATEGORY_SAVE_2("10002", "保存分类失败:分类代码不能为空!"),
    GOODS_CATEGORY_SAVE_3("10003", "保存分类失败:分类名称不能为空!"),
    GOODS_CATEGORY_SAVE_4("10004", "保存分类失败:分类代码:{0} 已存在!"),
    GOODS_CATEGORY_SAVE_5("10005", "保存分类失败:根据节点id:{0} 未查询到相应的分类!"),
    ;

    /**
     * 返回值代码
     */
    public String code;

    /**
     * 返回值消息
     */
    public String msg;

    RespMessageEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String formatMsg(Object... objects) {
        return MessageFormat.format(this.msg, objects);
    }


    @Override
    public String toString() {
        return this.code + " " + this.msg;
    }
}
