package com.example.lcj.copy.deep.MapStruct;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.example.lcj.copy.Address;
import com.google.common.collect.Lists;

public class DataUtil {

    /**
     * 模拟查询出一条数据
     *
     * @return
     */
    public static UserDO createData() {

        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address("北京1", "中国1");
        Address address2 = new Address("北京2", "中国2");
        addressList.add(address1);
        addressList.add(address2);

        UserDO van = new UserDO(1, "Van", LocalDateTime.now(), new BigDecimal(100L), addressList);

        van.setShoes(Lists.newArrayList("nika", "addd"));
        Address address = new Address("北京", "中国");
        van.setAddress(address);

        return van;
    }

    /**
     * 模拟查询出一条数据
     *
     * @return
     */
    public static UserExtDO createExtData() {
        Address address = new Address("北京", "中国");
        Address address1 = new Address("北京", "中国");
        Address address2 = new Address("北京", "中国");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        UserExtDO van = new UserExtDO(1, "Van", LocalDateTime.now(), new BigDecimal(100L), address, addressList, "南开");
        van.setAddress(address);
        return van;
    }
}
