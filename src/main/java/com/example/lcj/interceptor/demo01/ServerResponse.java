package com.example.lcj.interceptor.demo01;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/29 8:31
 */
@Data
public class ServerResponse {
    // 状态码
    private int code;
    // 描述
    private String desc;
    // 具体数据
    private List<Object> data;

    public enum GlobalStatus {
        SUCCESS(0, "成功"),
        FAILED(1, "失败"),
        ERROR(2, "失败");

        private final int code;
        private final String desc;

        private GlobalStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public ServerResponse(GlobalStatus status, String desc) {
        this.code = status.code;
        this.desc = desc;
    }

    public ServerResponse(GlobalStatus status) {
        this.desc = status.desc;
        this.code = status.code;
    }

    public void addObject(Object da){
        if (this.data == null) {
            this.data = new ArrayList<Object>();
        }
        this.data.add(da);
    }

    public <T> void setData(List<T> data) {
        this.data = (List) data;
    }
}
