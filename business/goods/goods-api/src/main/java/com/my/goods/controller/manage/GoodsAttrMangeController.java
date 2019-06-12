package com.my.goods.controller.manage;

import com.my.goods.domain.vo.GoodsAttrResultVo;
import com.my.goods.service.GoodsAttrMangeService;
import com.my.include.common.vo.RespVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/11 16:27
 */
@Api
@RestController
@RequestMapping("/goods/manage/attr")
public class GoodsAttrMangeController {
    @Autowired
    private GoodsAttrMangeService service;

    @GetMapping("/selectAttrByName")
    public RespVo<List<GoodsAttrResultVo>> selectByAttrName(@RequestParam(value = "attrName", required = false) String attrName) {
        List<GoodsAttrResultVo> resultVos = service.selectByName(attrName);
        return RespVo.buildSuccess(resultVos);
    }
}
