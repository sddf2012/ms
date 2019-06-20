package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryResultVo;
import com.my.goods.domain.vo.GoodsCategorySaveVo;
import com.my.goods.service.GoodsCategoryManageService;
import com.my.include.common.domain.vo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 9:55
 */
@RequestMapping("/goods/manage/category")
@RestController
@Api(value = "商品分类管理")
public class GoodsCategoryManageController {
    @Autowired
    private GoodsCategoryManageService categoryManageService;

    @GetMapping(value = "/searchAll")
    @ApiOperation(value = "查询全部商品分类")
    public RespVo<List<GoodsCategoryResultVo>> searchAll() {
        List<GoodsCategoryResultVo> list = categoryManageService.selectAllByParentId(0);
        return RespVo.buildSuccess(list);
    }

    @GetMapping(value = "/searchAll/{categoryId}")
    @ApiOperation(value = "查询指定节点下的所有子分类")
    public RespVo<List<GoodsCategoryResultVo>> searchChildren(@PathVariable("categoryId") Integer categoryId) {
        List<GoodsCategoryResultVo> list = categoryManageService.selectAllByParentId(categoryId);
        return RespVo.buildSuccess(list);
    }

    @GetMapping(value = "/searchNext/{categoryId}")
    @ApiOperation(value = "查询指定节点下的下一级子分类")
    public RespVo<List<GoodsCategoryResultVo>> searchNextLevelChildren(@PathVariable("categoryId") Integer categoryId) {
        List<GoodsCategoryResultVo> list = categoryManageService.selectOneByParentId(categoryId);
        return RespVo.buildSuccess(list);
    }

    @PostMapping(value = "/saveCategory")
    @ApiOperation(value = "新增或更新节点")
    public RespVo<GoodsCategoryResultVo> saveCategory(@RequestBody GoodsCategorySaveVo saveVo) {
        GoodsCategoryResultVo goodsCategoryResultVo = categoryManageService.saveCategory(saveVo);
        return RespVo.buildSuccess(goodsCategoryResultVo);
    }

    @GetMapping(value = "/deleteCategory/{categoryId}")
    @ApiOperation(value = "删除节点及其子节点")
    public RespVo<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryManageService.deleteByCategoryId(categoryId);
        return RespVo.buildStringSuccess();
    }
}
