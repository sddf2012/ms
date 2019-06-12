package com.my.goods.service.impl;

import com.my.goods.domain.entity.GoodsAttr;
import com.my.goods.domain.vo.GoodsAttrResultVo;
import com.my.goods.repo.GoodsAttrMapper;
import com.my.goods.service.GoodsAttrMangeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/11 16:23
 */
@Service
public class GoodsAttrMangeServiceImpl implements GoodsAttrMangeService {
    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    @Override
    public List<GoodsAttrResultVo> selectByName(String name) {
        List<GoodsAttr> list = goodsAttrMapper.selectByAttrName(name);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.stream().map(this::entityToVo).collect(Collectors.toList());
    }

    private GoodsAttrResultVo entityToVo(GoodsAttr entity) {
        if (entity == null) {
            return null;
        }
        GoodsAttrResultVo resultVo = new GoodsAttrResultVo();
        BeanUtils.copyProperties(entity, resultVo);
        return resultVo;
    }
}
