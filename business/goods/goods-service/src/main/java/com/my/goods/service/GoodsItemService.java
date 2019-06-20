package com.my.goods.service;

import com.my.goods.domain.vo.GoodsItemQueryVo;
import com.my.goods.domain.vo.GoodsItemResultVo;
import com.my.include.common.domain.vo.PageResp;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 17:09
 */
public interface GoodsItemService {
     PageResp<GoodsItemResultVo> getItemByCaId(GoodsItemQueryVo queryVo);
}
