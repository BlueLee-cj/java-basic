package com.example.lcj.copy.deep.BeanCopier;

import org.junit.Test;

import com.example.lcj.copy.deep.MapStruct.DataUtil;
import com.example.lcj.copy.deep.MapStruct.UserDO;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;

/**
 * @author lichengjian
 * @date 2021/12/16
 */
@Slf4j
public class Demo {
    /**
     * 属性名称、类型都相同(部分属性不拷贝)
     */
    @Test
    public void normalCopy() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器（下面会介绍），下同
        BeanCopier b = BeanCopier.create(UserDO.class, UserDTO.class, false);
        UserDTO userDTO = new UserDTO();
        b.copy(userDO, userDTO, null);
        log.info("拷贝后：userDTO:{}", userDTO);
    }


    /**
     * 类型不同,不使用Converter
     */
    @Test
    public void noConverterTest() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        BeanCopier copier =
                BeanCopier.create(UserDO.class, com.example.lcj.copy.deep.MapStruct.UserDomain.class, false);
        UserDomain userDomain =
                new UserDomain();
        copier.copy(userDO, userDomain, null);
        log.info("拷贝后：userDomain:{}", userDomain);

    }

    /**
     * 类型不同,使用Converter
     */
    @Test
    public void converterTest() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        BeanCopier copier = BeanCopier.create(UserDO.class, UserDomain.class, true);
        UserConverter converter = new UserConverter();
        UserDomain userDomain = new UserDomain();
        copier.copy(userDO, userDomain, converter);
        log.info("拷贝后：userDomain:{}", userDomain);
    }

}
