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

    REQ_PARAM_NULL("00002", "请求参数不能为空!"),
    REQ_PARAM_VALIDATE("00003", "请求参数异常!"),

    /**
     * 商品模块
     */
    GOODS_ADD_CATEGORY_1("10001", "新增分类失败:根据父节点id未找到相应的分类!"),
    GOODS_ADD_CATEGORY_2("10002", "新增分类失败:节点categoryCode不能为空!"),
    GOODS_ADD_CATEGORY_3("10003", "新增分类失败:节点categoryName不能为空!"),


    GOODS_UPDATE_CATEGORY("10005", "更新分类失败:根据节点id未查询到相应的分类!");

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


    @Override
    public String toString() {
        return this.code + " " + this.msg;
    }
}
