package com.my.system.service;

import com.my.system.domain.vo.SysDictionaryResultVo;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 11:13
 */
public interface DictionaryService {
    List<SysDictionaryResultVo> getByCode(String code);

    List<SysDictionaryResultVo> getByCodes(List<String> codes);
}
