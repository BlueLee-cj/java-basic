package com.example.lcj.dozer.controller;

import com.example.lcj.dozer.entity.ContacterDO;
import com.example.lcj.dozer.vo.ContacterVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contacter")
public class ContacterController {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @GetMapping("/add")
    public ContacterDO add(ContacterVO contacterVO) {
        System.out.println("添加一个联系人");
        //使用dozer进行转换
        ContacterDO contacterDO = dozerBeanMapper.map(contacterVO, ContacterDO.class);
        return contacterDO;
    }

}