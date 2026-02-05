package com.example.lcj.copy.deep.springbeanutils;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.example.lcj.copy.deep.MapStruct.DataUtil;
import com.example.lcj.copy.deep.MapStruct.UserDO;
import com.example.lcj.copy.deep.MapStruct.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtilsDemo {

    public static void main1(String[] args) {

        UserDO userDO = DataUtil.createData();
        log.info("拷贝前,userDO:{}", userDO);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDO, userDTO);

        log.info("拷贝后,userDO:{}", userDO);
        log.info("拷贝后,userDto:{}", userDTO);
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ss", null);
        System.out.println(map);

    }
}
