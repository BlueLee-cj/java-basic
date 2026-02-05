package com.example.lcj.copy.deep.MapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

/**
 * 
 * FileName: UserConvertUtils
 *
 * @author: Van
 *          Date: 2019-11-08 20:56
 *          Description: ${DESCRIPTION}
 *          Version： V1.0
 */
@Mapper(mappingControl = DeepClone.class)
public interface UserConvertUtils {

    UserConvertUtils INSTANCE = Mappers.getMapper(UserConvertUtils.class);

    /**
     * 普通的映射
     *
     * @param userDO UserDO数据持久层类
     * @return 数据传输类
     */
    @Mappings({
            @Mapping(target = "gmtBroth", source = "gmtBroth")
    })
    UserDTO doToDTO(UserDO userDO);

    /**
     * 类型转换的映射
     *
     * @param userDO UserDO数据持久层类
     * @return 数据传输类
     */
    @Mappings({
            @Mapping(target = "gmtBroth", source = "gmtBroth")
    })
    UserDTO doToDtoWithConvert(UserDO userDO);


    /**
     * 普通的映射
     *
     * @param userExtDO UserDO数据持久层类
     * @return 数据传输类
     */
    @Mappings({
            @Mapping(target = "gmtBroth", source = "gmtBroth")
    })
    UserExtDTO doToDTO(UserExtDO userExtDO);

}


