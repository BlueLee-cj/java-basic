package com.example.lcj.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User02 {

    private String name;
    private Address02 address;

}