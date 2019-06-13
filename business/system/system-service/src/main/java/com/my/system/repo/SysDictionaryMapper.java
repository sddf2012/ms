package com.my.system.repo;

import com.my.system.domain.entity.SysDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictionaryMapper {
    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);

    List<SysDictionary> selectByCode(@Param("code") String code);

    List<SysDictionary> selectByCodes(@Param("codes") List<String> codes);

}