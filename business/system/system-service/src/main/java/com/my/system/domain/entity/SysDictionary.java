package com.my.system.domain.entity;

import com.my.include.common.domain.entity.BaseUpdated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictionary extends BaseUpdated {
    private Integer id;

    private String code;

    private String itemCode;

    private String itemValue;

    private String description;

    private Integer status;
}