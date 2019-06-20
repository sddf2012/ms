package com.my.goods.controller;

import com.my.goods.domain.vo.GoodsItemQueryVo;
import com.my.goods.domain.vo.GoodsItemResultVo;
import com.my.goods.service.GoodsItemService;
import com.my.include.common.domain.vo.PageResp;
import com.my.include.common.domain.vo.RespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 17:00
 */
@Api
@RestController("/goods/item")
public class ItemController {
    @Autowired
    private GoodsItemService itemService;

    @ApiOperation("根据分类查询商品信息")
    @PostMapping("/getItemByCaId")
    public RespVo<PageResp<GoodsItemResultVo>> getItemByCaId(@RequestBody GoodsItemQueryVo queryVo) {
        PageResp<GoodsItemResultVo> resp = itemService.getItemByCaId(queryVo);
        return RespVo.buildSuccess(resp);
    }
}
