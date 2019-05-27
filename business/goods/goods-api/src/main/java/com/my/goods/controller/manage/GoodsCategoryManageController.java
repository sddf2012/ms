package com.my.goods.controller.manage;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 9:55
 */
@RequestMapping("/goods/manage/category")
@RestController
@ApiOperation(value = "商品分类管理")
public class GoodsCategoryManageController {
    @PostMapping(value = "/search")
    @ApiOperation(value = "查询商品分类")
    public void select( ){

    }
}
