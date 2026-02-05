package com.example.lcj.copy.deep.MapStruct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.lcj.copy.Address;
import com.example.lcj.copy.Address01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;
    private String userName;
    private List<String> shoes;
    /**
     * 以下两个字段用户模拟自定义转换
     */
    private LocalDateTime gmtBroth;
    private BigDecimal balances;
    private Address01 address;
    private List<Address01> addressList;
    private List<Address> addresses;
}
