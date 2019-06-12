package com.my.goods.service.impl;

import com.my.goods.domain.entity.GoodsCategoryAttrValue;
import com.my.goods.domain.vo.GoodsCategoryAttrValueResultVo;
import com.my.goods.repo.GoodsCategoryAttrValueMapper;
import com.my.goods.service.GoodsCategoryAttrValueManageService;
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
 * date: 2019/6/6 14:13
 */
@Service
public class GoodsCategoryAttrValueManageServiceImpl implements GoodsCategoryAttrValueManageService {
    @Autowired
    private GoodsCategoryAttrValueMapper attrValueMapper;

    @Override
    public List<GoodsCategoryAttrValueResultVo> selectByCaId(Integer caId) {
        List<GoodsCategoryAttrValue> list = attrValueMapper.selectByCaId(caId);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.stream().map(this::entityToVo).collect(Collectors.toList());
        }
    }

    @Override
    public List<GoodsCategoryAttrValueResultVo> selectByCaIdAndValue(Integer caId, String value) {
        List<GoodsCategoryAttrValue> list = attrValueMapper.selectByCaIdAndValue(caId,value);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.stream().map(this::entityToVo).collect(Collectors.toList());
        }
    }

    private GoodsCategoryAttrValueResultVo entityToVo(GoodsCategoryAttrValue attrValue) {
        if (attrValue == null) {
            return null;
        }
        GoodsCategoryAttrValueResultVo resultVo = new GoodsCategoryAttrValueResultVo();
        BeanUtils.copyProperties(attrValue, resultVo);
        return resultVo;
    }
}
