package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryAddVo;
import com.my.goods.domain.vo.GoodsCategoryRo;
import com.my.goods.domain.vo.GoodsCategoryUpdateVo;
import com.my.goods.service.GoodsCategoryManageService;
import com.my.include.common.vo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public RespVo<List<GoodsCategoryRo>> searchAll() {
        List<GoodsCategoryRo> list = categoryManageService.selectAllByParentId(0);
        return RespVo.buildSuccess(list);
    }

    @GetMapping(value = "/search/{categoryId}")
    @ApiOperation(value = "查询指定节点下的子分类")
    public RespVo<List<GoodsCategoryRo>> searchChilds(@PathVariable("categoryId") Integer categoryId) {
        List<GoodsCategoryRo> list = categoryManageService.selectAllByParentId(categoryId);
        return RespVo.buildSuccess(list);
    }

    @PostMapping(value = "/addCategory")
    @ApiOperation(value = "新增节点")
    public RespVo<String> addCategory(@RequestBody @Valid List<GoodsCategoryAddVo> addVos) {
        categoryManageService.addCategory(addVos);
        return RespVo.buildStringSuccess();
    }

    @PostMapping(value = "/updateCategory")
    @ApiOperation(value = "更新节点")
    public RespVo<String> updateCategory(@RequestBody @Valid List<GoodsCategoryUpdateVo> updateVos) {
        categoryManageService.updateCategory(updateVos);
        return RespVo.buildStringSuccess();
    }

    @GetMapping(value = "/deleteCategory/{categoryId}")
    @ApiOperation(value = "删除节点及其子节点")
    public RespVo<String> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryManageService.deleteByCategoryId(categoryId);
        return RespVo.buildStringSuccess();
    }

    @PostMapping(value = "/addCategory2")
    @ApiOperation(value = "新增节点")
    public RespVo<String> addCategory2(@RequestBody GoodsCategoryAddVo addVo) {
        List<GoodsCategoryAddVo> list = new ArrayList<>();
        list.add(addVo);
        categoryManageService.addCategory(list);
        return RespVo.buildStringSuccess();
    }
}
