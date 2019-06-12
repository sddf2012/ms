package com.my.goods.service;

import com.my.goods.domain.vo.GoodsAttrResultVo;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/11 16:22
 */
public interface GoodsAttrMangeService {
    List<GoodsAttrResultVo> selectByName(String name);
}
