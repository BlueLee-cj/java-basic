package com.example.lcj.dozer.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

}