package com.example.lcj.json.fastjson;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/27 10:12
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestClass t = JSONObject.parseObject("{" +
                "\"ceShi1\": \"1\"," +
                "\"ceShi2\": \"2\"," +
                "\"ceShi3\": \"3\"," +
                "\"ceShi4\": \"4\"," +
                "\"ceShi5\": \"5\"," +
                "\"ceShi6\": \"6\"," +
                "\"ceShi7\": \"7\"," +
                "\"ceShi8\": \"8\"," +
                "\"ceShi9\": \"9\"," +
                "\"ceShi10\": \"10\"," +
                "\"ceShi11\": \"11\"," +
                "\"ceShi12\": \"12\"," +
                "\"ceShi13\": \"13\"," +
                "\"ceShi14\": \"14\"," +
                "\"ceShi15\": \"15\"," +
                "\"ceShi16\": \"16\"," +
                "\"ceShi17\": \"17\"," +
                "\"ceShi18\": \"18\"," +
                "\"ceShi19\": \"19\"," +
                "\"ceShi20\": \"20\"," +
                "\"ceShi21\": \"21\"," +
                "\"ceShi22\": \"22\"," +
                "\"ceShi23\": \"23\"," +
                "\"ceShi24\": \"24\"," +
                "\"ceShi25\": \"25\"," +
                "\"ceShi26\": \"26\"," +
                "\"ceShi27\": \"27\"," +
                "\"ceShi28\": \"28\"," +
                "\"ceShi29\": \"29\"," +
                "\"ceShi30\": \"30\"," +
                "\"ceShi31\": \"31\"," +
                "\"ceShi32\": \"32\"" +
                //"\"ceShi33\": \"33\"" +
                "    }", TestClass.class);
    }
}
