package com.example.lcj.copy.deep.MapStruct.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source {
    private Integer id;
    private String name; // 映射 Target.targetName

    private long birth;

    private Integer typeCode; // 映射 Target.type.code
    private String typeName; // 映射 Target.type.name

    public Source(Integer id, String name, Integer typeCode, String typeName) {
        this.id = id;
        this.name = name;
        this.typeCode = typeCode;
        this.typeName = typeName;
    }
}
