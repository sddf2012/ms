package com.my.goods.constants.enums;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 19:08
 */
public interface ItemEnum {
    enum Status{
        /**
         *
         */
        DELETE(0,"删除"),
        ON_SHELVES(1,"上架"),
        OFF_SHELVES(2,"下架");

        public int code;
        public String value;

        Status(int code, String value) {
            this.code = code;
            this.value = value;
        }
    }
}
