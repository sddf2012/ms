package com.my.goods.service.impl;

import com.github.pagehelper.Page;
import com.my.goods.constants.enums.ItemEnum;
import com.my.goods.domain.entity.Item;
import com.my.goods.domain.vo.GoodsItemQueryVo;
import com.my.goods.domain.vo.GoodsItemResultVo;
import com.my.goods.repo.ItemMapper;
import com.my.goods.service.GoodsItemService;
import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.domain.vo.PageResp;
import com.my.include.common.domain.vo.RespVo;
import com.my.stock.feign.StockFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 17:46
 */
@Slf4j
@Service
public class GoodsItemServiceImpl implements GoodsItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private StockFeign stockFeign;

    @Override
    public PageResp<GoodsItemResultVo> getItemByCaId(GoodsItemQueryVo queryVo) {
        List<Item> itemList = itemMapper.getItemByCaId(queryVo.getCategoryId(), ItemEnum.Status.ON_SHELVES.code, queryVo.getPageNum(), queryVo.getPageSize());
        if (CollectionUtils.isEmpty(itemList)) {
            return null;
        }
        List<GoodsItemResultVo> resultVos = new ArrayList<>();
        List<Integer> itemIds = new ArrayList<>();
        itemList.forEach(item -> {
            resultVos.add(entity2ResultVo(item));
            itemIds.add(item.getItemId());

        });

        Map<Integer, Integer> map=null ;
        try {
            RespVo<Map<Integer, Integer>> respVo = stockFeign.selectByIds(itemIds);
            if (respVo == null) {
                log.error(RespMessageEnum.FEIGN_RESP_NULL.formatMsg("库存", "获取商品库存"));
            } else if (!RespMessageEnum.SUCCESS.code.equals(respVo.getRespCode())) {
                log.error(RespMessageEnum.FEIGN_RESP_ERROR.formatMsg("库存", "获取商品库存", respVo.getRespCode() + " " + respVo.getRespMsg()));
            } else {
                map = respVo.getData();
            }

        } catch (Exception e) {
            log.error(RespMessageEnum.FEIGN_INVOKE_ERROR.formatMsg("库存", "获取商品库存", e.getMessage()));
        }

        if (!CollectionUtils.isEmpty(map)) {
            for (GoodsItemResultVo resultVo:resultVos){
              Integer stock=  map.get(resultVo.getItemId());
              if(stock!=null){
                  resultVo.setStock(stock);
              }
            }
        }

        return new PageResp<>((Page<Item>)itemList,resultVos);
    }

    private GoodsItemResultVo entity2ResultVo(Item item) {
        if (item == null) {
            return null;
        }
        GoodsItemResultVo resultVo = new GoodsItemResultVo();
        BeanUtils.copyProperties(item, resultVo);
        return resultVo;
    }
}
