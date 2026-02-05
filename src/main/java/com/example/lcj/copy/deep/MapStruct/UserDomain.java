package com.example.lcj.copy.deep.MapStruct;

import lombok.Data;

@Data
public class UserDomain {
    private Integer id;
    private String userName;
    
    /**
     * 以下两个字段用户模拟自定义转换
     */
    private String gmtBroth;
    private String balance;
}