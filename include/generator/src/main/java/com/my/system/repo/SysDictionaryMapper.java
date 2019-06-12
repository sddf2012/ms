package com.my.system.repo;

import com.my.system.domain.entity.SysDictionary;

public interface SysDictionaryMapper {
    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);
}