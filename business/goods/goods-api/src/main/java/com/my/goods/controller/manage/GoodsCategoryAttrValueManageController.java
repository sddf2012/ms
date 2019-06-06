package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryAttrValueResultVo;
import com.my.goods.service.GoodsCategoryAttrValueManageService;
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
 * date: 2019/6/6 14:17
 */
@Api
@RestController
@RequestMapping("/goods/manage/categoryAttrValue")
public class GoodsCategoryAttrValueManageController {
    @Autowired
    private GoodsCategoryAttrValueManageService attrValueManageService;

    @ApiOperation(value = "根据分类属性id查询所有属性值")
    @GetMapping("/selectByCaId/{caId}")
    public RespVo<List<GoodsCategoryAttrValueResultVo>> selectByCaId(@PathVariable("caId") Integer caId) {
        List<GoodsCategoryAttrValueResultVo> attrValues = attrValueManageService.selectByCaId(caId);
        return RespVo.buildSuccess(attrValues);
    }
}
