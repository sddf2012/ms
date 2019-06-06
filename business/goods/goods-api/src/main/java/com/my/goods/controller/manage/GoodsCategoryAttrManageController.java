package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryAttrResultVo;
import com.my.goods.service.GoodsCategoryAttrManageService;
import com.my.include.common.vo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
