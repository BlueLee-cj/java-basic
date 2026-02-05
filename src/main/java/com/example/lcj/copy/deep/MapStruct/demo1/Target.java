package com.example.lcj.copy.deep.MapStruct.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Target {
    private Integer id;
    private String targetName;

    private Date birth;

    private ComplexEnumType type;

    public Target(Integer id, String targetName, ComplexEnumType type) {
        this.id = id;
        this.targetName = targetName;
        this.type = type;
    }
}
