package com.my.goods.domain.vo;

import com.my.include.common.domain.vo.PageReq;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 17:06
 */
@Data
public class GoodsItemQueryVo extends PageReq {
    @NotNull(message = "分类不能为空")
    private Integer categoryId;
}
