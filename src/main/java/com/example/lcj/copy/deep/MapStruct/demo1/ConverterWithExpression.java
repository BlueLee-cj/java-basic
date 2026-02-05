package com.example.lcj.copy.deep.MapStruct.demo1;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {Date.class})
public interface ConverterWithExpression {
    ConverterWithExpression INSTANCE = Mappers.getMapper(ConverterWithExpression.class);

    @Mapping(source = "name", target = "targetName")
    @Mapping(target = "birth", expression = "java(new Date(source.getBirth()))")
    @Mapping(target = "type", expression = "java(ComplexEnumType.getByCode(source.getTypeCode()))")
    Target fromSource(Source source);

    // @InheritInverseConfiguration
    @Mapping(target = "birth", expression = "java(target.getBirth().getTime())")
    @Mapping(target = "typeCode", source = "type.code")
    @Mapping(target = "typeName", source = "type.name")
    Source toSource(Target target);
}
