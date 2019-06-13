package com.my.goods.service.impl;

import com.my.goods.domain.entity.GoodsCategoryAttrValue;
import com.my.goods.domain.vo.GoodsCategoryAttrValueResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrValueSaveVo;
import com.my.goods.repo.GoodsCategoryAttrValueMapper;
import com.my.goods.service.GoodsCategoryAttrValueManageService;
import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.exception.BusinessException;
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
        List<GoodsCategoryAttrValue> list = attrValueMapper.selectByCaIdAndValueLike(caId, value);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.stream().map(this::entityToVo).collect(Collectors.toList());
        }
    }

    @Override
    public int deleteById(Integer cavId) {
        return attrValueMapper.deleteById(cavId);
    }

    @Override
    public GoodsCategoryAttrValueResultVo saveAttrValue(GoodsCategoryAttrValueSaveVo saveVo) {
        if (saveVo.getCavId() == null) {
            return addAttrValue(saveVo);
        } else {
            return updateAttrValue(saveVo);
        }
    }

    private GoodsCategoryAttrValueResultVo updateAttrValue(GoodsCategoryAttrValueSaveVo saveVo) {
        String errMsg;
        Integer cavId = saveVo.getCavId();
        GoodsCategoryAttrValue entity = attrValueMapper.selectByCavId(cavId);
        if (entity == null) {
            errMsg = RespMessageEnum.GOODS_CA_SAVE_20.formatMsg(cavId);
            throw new BusinessException(RespMessageEnum.GOODS_CA_SAVE_20.code, errMsg);
        }
        if (!saveVo.getValue().equals(entity.getValue())) {
            int current = attrValueMapper.selectByCaIdAndValueExcludeCavid(saveVo.getCaId(), saveVo.getValue(), cavId);
            if (current > 0) {
                errMsg = RespMessageEnum.GOODS_CA_SAVE_21.formatMsg(saveVo.getValue());
                throw new BusinessException(RespMessageEnum.GOODS_CA_SAVE_21.code, errMsg);
            }
            entity.setValue(saveVo.getValue());
            entity.setUpdatedUser(saveVo.getOperator());
            attrValueMapper.updateSelective(entity);
        }
        return entityToVo(entity);
    }

    private GoodsCategoryAttrValueResultVo addAttrValue(GoodsCategoryAttrValueSaveVo saveVo) {
        String errMsg;
        GoodsCategoryAttrValue entity = attrValueMapper.selectByCaIdAndValue(saveVo.getCaId(), saveVo.getValue());
        if (entity != null) {
            errMsg = RespMessageEnum.GOODS_CA_SAVE_22.formatMsg(saveVo.getValue());
            throw new BusinessException(RespMessageEnum.GOODS_CA_SAVE_22.code, errMsg);
        }
        entity = new GoodsCategoryAttrValue();
        BeanUtils.copyProperties(saveVo, entity);
        entity.setCreatedUser(saveVo.getOperator());
        attrValueMapper.insertSelective(entity);
        return entityToVo(entity);
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
