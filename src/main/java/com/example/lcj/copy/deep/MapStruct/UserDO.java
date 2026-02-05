package com.example.lcj.copy.deep.MapStruct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.lcj.copy.Address;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDO {

    private int id;
    private String userName;
    private List<String> shoes;
    /**
     * 以下两个字段用户模拟自定义转换
     */
    private LocalDateTime gmtBroth;
    private BigDecimal balance;
    private Address address;
    private List<Address> addresses;

    public UserDO(int id, String userName, LocalDateTime gmtBroth, BigDecimal balance, List<Address> addresses) {
        this.id = id;
        this.userName = userName;
        this.gmtBroth = gmtBroth;
        this.balance = balance;
        this.addresses = addresses;
    }

    public UserDO(int id, String userName, LocalDateTime gmtBroth, BigDecimal balance, Address address,
            List<Address> addresses) {
        this.id = id;
        this.userName = userName;
        this.gmtBroth = gmtBroth;
        this.balance = balance;
        this.address = address;
        this.addresses = addresses;
    }

    public UserDO(int id, String userName, List<String> shoes, LocalDateTime gmtBroth, BigDecimal balance,
            Address address, List<Address> addresses) {
        this.id = id;
        this.userName = userName;
        this.shoes = shoes;
        this.gmtBroth = gmtBroth;
        this.balance = balance;
        this.address = address;
        this.addresses = addresses;
    }
}
