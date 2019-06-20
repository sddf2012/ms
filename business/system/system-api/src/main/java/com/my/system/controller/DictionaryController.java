package com.my.system.controller;

import com.my.include.common.domain.vo.RespVo;
import com.my.system.domain.vo.SysDictionaryResultVo;
import com.my.system.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/12 11:32
 */
@Api
@Slf4j
@RestController
@RequestMapping("/system/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation("根据代码查询数据字典")
    @GetMapping("/getByCode/{code}")
    public RespVo<List<SysDictionaryResultVo>> getByCode(@PathVariable("code") String code) {
        List<SysDictionaryResultVo> list = dictionaryService.getByCode(code);
        return RespVo.buildSuccess(list);
    }

    @ApiOperation("根据多个代码查询数据字典")
    @PostMapping("/getByCodes")
    public RespVo<List<SysDictionaryResultVo>> getByCode(@RequestBody List<String> codes) {
        List<SysDictionaryResultVo> list = dictionaryService.getByCodes(codes);
        return RespVo.buildSuccess(list);
    }
}
