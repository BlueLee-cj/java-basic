package com.example.lcj.dozer;

import org.dozer.Mapping;

public class SourceBean {

    private Long id;

    private String name;

    @Mapping("binaryData")
    private String data;

    @Mapping("pk")
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}