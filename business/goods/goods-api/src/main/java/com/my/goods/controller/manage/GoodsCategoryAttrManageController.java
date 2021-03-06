package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryAttrResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrSaveVo;
import com.my.goods.service.GoodsCategoryAttrManageService;
import com.my.include.common.domain.vo.PageResp;
import com.my.include.common.domain.vo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 10:11
 */
@RestController
@Api
@RequestMapping("/goods/manage/categoryAttr")
public class GoodsCategoryAttrManageController {
    @Autowired
    public GoodsCategoryAttrManageService attrManageService;

    @ApiOperation(value = "根据分类代码查询分类属性")
    @GetMapping("/getGoodsCategoryAttr/{categoryId}")
    public RespVo<List<GoodsCategoryAttrResultVo>> getGoodsCategoryAttr(@PathVariable("categoryId") Integer categoryId) {
        List<GoodsCategoryAttrResultVo> detail = attrManageService.selectByCategoryId(categoryId);
        return RespVo.buildSuccess(detail);
    }

    @ApiOperation(value = "根据分类代码查询分类属性")
    @GetMapping("/getGoodsCategoryAttrPage/{categoryId}")
    public RespVo<PageResp<GoodsCategoryAttrResultVo>> getGoodsCategoryAttrPage(@PathVariable("categoryId") Integer categoryId, @RequestParam int pageNum, @RequestParam int pageSize) {
        PageResp<GoodsCategoryAttrResultVo> detail = attrManageService.selectByCategoryIdPage(categoryId,pageNum,pageSize);
        return RespVo.buildSuccess(detail);
    }

    @ApiOperation("新增或更新分类属性")
    @PostMapping("/saveCategoryAttr")
    public RespVo<GoodsCategoryAttrResultVo> saveCa(@RequestBody GoodsCategoryAttrSaveVo saveVo) {
        GoodsCategoryAttrResultVo resultVo = attrManageService.saveCa(saveVo);
        return RespVo.buildSuccess(resultVo);
    }

    @ApiOperation(value = "根据id删除分类属性")
    @GetMapping("/deleteCaById/{caId}")
    public RespVo<String> deleteCaById(@PathVariable("caId") Integer caId) {
       attrManageService.deleteCaById(caId);
        return RespVo.buildStringSuccess();
    }

}
