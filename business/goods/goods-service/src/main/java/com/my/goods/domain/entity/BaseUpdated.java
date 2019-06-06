package com.my.goods.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/5 19:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUpdated extends BaseCreated {
    private Date updatedUser;

    private Date updatedTime;
}
