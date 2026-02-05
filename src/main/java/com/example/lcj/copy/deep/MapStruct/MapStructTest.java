package com.example.lcj.copy.deep.MapStruct;

import java.math.BigDecimal;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapStructTest {
    /**
     * 一般拷贝
     */
    @Test
    public void normalCopy() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        UserDTO userDTO = UserConvertUtils.INSTANCE.doToDTO(userDO);
        userDTO.getAddress().setCity("nnnn");
        log.info("拷贝后：userDO:{}", userDO);
        log.info("拷贝后：userDTO:{}", userDTO);
    }

    /**
     * 包含类型转换的拷贝
     */
    @Test
    public void doToDtoWithConvert() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        UserDTO userDTO = UserConvertUtils.INSTANCE.doToDtoWithConvert(userDO);
        userDTO.setBalances(new BigDecimal("23323"));
        log.info("拷贝后：userDO:{}", userDO);
        log.info("拷贝后：userDTO:{}", userDTO);
    }

    /**
     * 一般拷贝
     */
    @Test
    public void extendCopy() {
        // 模拟查询出数据
        UserExtDO userExtDO = DataUtil.createExtData();
        log.info("拷贝前：userExtDO:{}", userExtDO);
        UserExtDTO userExtDTO = UserConvertUtils.INSTANCE.doToDTO(userExtDO);
        userExtDTO.getAddress().setCity("nnnn");
        log.info("拷贝后：userExtDO:{}", userExtDO);
        log.info("拷贝后：userExtDTO:{}", userExtDTO);
    }
}
