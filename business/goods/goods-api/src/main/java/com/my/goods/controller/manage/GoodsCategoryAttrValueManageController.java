package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsCategoryAttrValueResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrValueSaveVo;
import com.my.goods.service.GoodsCategoryAttrValueManageService;
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
 * date: 2019/6/6 14:17
 */
@Api
@RestController
@RequestMapping("/goods/manage/categoryAttrValue")
public class GoodsCategoryAttrValueManageController {
    @Autowired
    private GoodsCategoryAttrValueManageService attrValueManageService;

    @ApiOperation(value = "根据分类属性id即属性值查询相应属性")
    @GetMapping("/selectByCaId/{caId}")
    public RespVo<List<GoodsCategoryAttrValueResultVo>> selectByCaId(@PathVariable("caId") Integer caId, @RequestParam(value = "value", required = false) String value) {
        List<GoodsCategoryAttrValueResultVo> attrValues = attrValueManageService.selectByCaIdAndValue(caId, value);
        return RespVo.buildSuccess(attrValues);
    }

    @ApiOperation(value = "根据id删除属性值")
    @GetMapping("/deleteCavById/{cavId}")
    public RespVo<String> deleteCavById(@PathVariable("cavId") Integer cavId) {
        attrValueManageService.deleteById(cavId);
        return RespVo.buildStringSuccess();
    }

    @ApiOperation("保存属性值")
    @PostMapping("/saveCav")
    public RespVo<GoodsCategoryAttrValueResultVo> saveCav(@RequestBody GoodsCategoryAttrValueSaveVo saveVo) {
        GoodsCategoryAttrValueResultVo resultVo = attrValueManageService.saveAttrValue(saveVo);
        return RespVo.buildSuccess(resultVo);
    }
}
