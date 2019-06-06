package com.my.goods.service.impl;

import com.my.goods.domain.entity.extension.GoodsCategoryAttrDetail;
import com.my.goods.domain.vo.GoodsCategoryAttrResultVo;
import com.my.goods.repo.GoodsCategoryAttrMapper;
import com.my.goods.service.GoodsCategoryAttrManageService;
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
        List<GoodsCategoryAttrDetail> list= goodsCategoryAttrMapper.selectByCategoryId(categoryId);
       return list.stream().map(detail->entityToVo(detail)).collect(Collectors.toList());
    }

    private GoodsCategoryAttrResultVo entityToVo(GoodsCategoryAttrDetail attrDetail) {
        if (attrDetail == null) {
            return null;
        }
        GoodsCategoryAttrResultVo resultVo = new GoodsCategoryAttrResultVo();
        BeanUtils.copyProperties(attrDetail, resultVo);
        resultVo.setType(attrDetail.getType());
        return resultVo;
    }
}
