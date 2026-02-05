package com.example.lcj.designpattern.adapter.demo05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/30 16:09
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {
    /*
     * 员工的家庭信息
     */
    public Map getUserHomeInfo() {
        HashMap homeInfo = new HashMap();

        homeInfo.put("homeTelNumbner", "员工的家庭电话是....");
        homeInfo.put("homeAddress", "员工的家庭地址是....");

        return homeInfo;
    }
}
