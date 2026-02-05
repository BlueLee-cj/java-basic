package com.example.lcj.copy.deep.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable{

    private String name;
    private Address address;

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setAddress(this.address.clone());
        return user;
    }
}
