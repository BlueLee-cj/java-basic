package com.example.lcj.copy.deep.MapStruct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.example.lcj.copy.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lichengjian
 * @date 2021/12/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExtDO extends UserDO {
    public UserExtDO(int id, String userName, LocalDateTime gmtBroth, BigDecimal balance, Address address,
                     List<Address> addresses, String school) {
        super(id, userName, gmtBroth, balance, address, addresses);
        this.school = school;
    }

    private String school;

}
