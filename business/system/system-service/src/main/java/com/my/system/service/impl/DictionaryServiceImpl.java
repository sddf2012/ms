package com.my.system.service.impl;

import com.my.system.domain.entity.SysDictionary;
import com.my.system.domain.vo.SysDictionaryResultVo;
import com.my.system.repo.SysDictionaryMapper;
import com.my.system.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 11:14
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private SysDictionaryMapper dictionaryMapper;

    @Override
    public List<SysDictionaryResultVo> getByCode(String code) {
        List<SysDictionary> list = dictionaryMapper.selectByCode(code);
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        return list.stream().map(this::entityToVo).collect(Collectors.toList());
    }

    @Override
    public List<SysDictionaryResultVo> getByCodes(List<String> codes) {
        List<SysDictionary> list = dictionaryMapper.selectByCodes(codes);
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        return list.stream().map(this::entityToVo).collect(Collectors.toList());
    }

    private SysDictionaryResultVo entityToVo(SysDictionary entity) {
        if (entity == null) {
            return null;
        }
        SysDictionaryResultVo resultVo = new SysDictionaryResultVo();
        BeanUtils.copyProperties(entity, resultVo);
        return resultVo;
    }
}
