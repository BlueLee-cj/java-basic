package com.example.lcj.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address02 {

    public Address02(String city, String country) {
        this.city = city;
        this.country = country;
    }

    private String city;
    private String country;
    private String region;

}