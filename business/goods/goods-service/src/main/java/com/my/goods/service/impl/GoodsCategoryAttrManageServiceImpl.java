package com.my.goods.service.impl;

import com.github.pagehelper.Page;
import com.my.goods.domain.entity.GoodsCategoryAttr;
import com.my.goods.domain.entity.extension.GoodsCategoryAttrDetail;
import com.my.goods.domain.vo.GoodsCategoryAttrResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrSaveVo;
import com.my.goods.repo.GoodsCategoryAttrMapper;
import com.my.goods.service.GoodsCategoryAttrManageService;
import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.exception.BusinessException;
import com.my.include.common.domain.vo.PageResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 10:05
 */
@Component
public class GoodsCategoryAttrManageServiceImpl implements GoodsCategoryAttrManageService {
    @Autowired
    private GoodsCategoryAttrMapper goodsCategoryAttrMapper;

    @Override
    public List<GoodsCategoryAttrResultVo> selectByCategoryId(Integer categoryId) {
        List<GoodsCategoryAttrDetail> list = goodsCategoryAttrMapper.selectByCategoryId(categoryId);
        return list.stream().map(detail -> entityToVo(detail)).collect(Collectors.toList());
    }

    @Override
    public GoodsCategoryAttrResultVo saveCa(GoodsCategoryAttrSaveVo saveVo) {
        if (saveVo.getCaId() != null) {
            return updateCa(saveVo);
        } else {
            return addCa(saveVo);
        }
    }

    @Override
    public PageResp<GoodsCategoryAttrResultVo> selectByCategoryIdPage(Integer categoryId, int pageNum, int pageSize) {
        Page<GoodsCategoryAttrDetail> list = (Page<GoodsCategoryAttrDetail>) goodsCategoryAttrMapper.selectByCategoryIdPage(categoryId,pageNum,pageSize);
        return new PageResp<>(list, this::entityToVo);
    }



    private GoodsCategoryAttrResultVo updateCa(GoodsCategoryAttrSaveVo saveVo) {
        String errMsg;
        int caId = saveVo.getCaId();
        GoodsCategoryAttr entity = goodsCategoryAttrMapper.selectById(caId);
        if (entity == null) {
            errMsg = RespMessageEnum.GOODS_CA_SAVE_10.formatMsg(caId);
            throw new BusinessException(RespMessageEnum.GOODS_CA_SAVE_10.code, errMsg);
        }
        entity.setType(saveVo.getType());
        entity.setSelected(saveVo.getSelected());
        entity.setUpdatedUser(saveVo.getOperator());
        goodsCategoryAttrMapper.updateSelective(entity);
        return entityToVo(entity);
    }

    private GoodsCategoryAttrResultVo addCa(GoodsCategoryAttrSaveVo saveVo) {
        String errMsg;
        Integer categoryId = saveVo.getCategoryId();
        Integer attrId = saveVo.getAttrId();
        if (categoryId == null || attrId == null) {
            errMsg = RespMessageEnum.REQ_PARAM_VALIDATE2.formatMsg("分类id和属性id不能为空!");
            throw new BusinessException(RespMessageEnum.REQ_PARAM_VALIDATE2.code, errMsg);
        }
        GoodsCategoryAttr current=  goodsCategoryAttrMapper.selectByCategoryIdAndAttrId(categoryId,attrId);
        if(current!=null){
            errMsg = RespMessageEnum.GOODS_CA_SAVE_11.formatMsg(saveVo.getAttrName());
            throw new BusinessException(RespMessageEnum.GOODS_CA_SAVE_11.code, errMsg);
        }
        GoodsCategoryAttr attr = new GoodsCategoryAttr();
        BeanUtils.copyProperties(saveVo, attr);
        attr.setCreatedUser(saveVo.getOperator());
        goodsCategoryAttrMapper.insertSelective(attr);
        return entityToVo(attr);

    }

    @Override
    public void deleteCaById(Integer caId) {
        goodsCategoryAttrMapper.deleteCaById(caId);
    }

    private GoodsCategoryAttrResultVo entityToVo(GoodsCategoryAttr attr) {
        if (attr == null) {
            return null;
        }
        GoodsCategoryAttrResultVo resultVo = new GoodsCategoryAttrResultVo();
        BeanUtils.copyProperties(attr, resultVo);
        resultVo.setType(attr.getType());
        return resultVo;
    }
}
