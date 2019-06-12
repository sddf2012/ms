package com.my.system.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 11:37
 */
@Data
public class SysDictionaryResultVo {
    private Integer id;

    private String code;

    private String itemCode;

    private String itemValue;

    private String description;

    private Date updatedUser;

    private Date updatedTime;

    private Date createdTime;

    private String createdUser;
}
