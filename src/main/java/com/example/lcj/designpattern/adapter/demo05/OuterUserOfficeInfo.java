package com.example.lcj.designpattern.adapter.demo05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/30 16:10
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {
    /*
     * 员工的工作信息，比如职位了等
     */
    public Map getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();

        officeInfo.put("jobPosition","这个人的职位是BOSS...");
        officeInfo.put("officeTelNumber", "员工的办公电话是....");

        return officeInfo;
    }
}
