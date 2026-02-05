package com.example.lcj.designpattern.adapter.demo05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/30 16:06
 */
public class OuterUserBaseInfo implements IOuterUserBaseInfo {
    /*
     * 用户的基本信息
     */
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();

        baseInfoMap.put("userName", "这个员工叫混世魔王....");
        baseInfoMap.put("mobileNumber", "这个员工电话是....");

        return baseInfoMap;
    }
}
