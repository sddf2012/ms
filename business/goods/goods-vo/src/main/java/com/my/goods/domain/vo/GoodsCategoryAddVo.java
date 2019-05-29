package com.my.goods.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:08
 */
@Data
public class GoodsCategoryAddVo {
    @NotNull(message = "父节点id不能为空!")
    private Integer parentId;

    @NotNull(message = "categoryCode不能为空!")
    private String categoryCode;

    @NotNull(message = "categoryName不能为空!")
    private String categoryName;

    private String createdUser;

    private List<GoodsCategoryAddVo> childs;
}
