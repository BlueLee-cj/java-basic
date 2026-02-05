package com.example.lcj.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichengjian
 * @date 2024/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @ExcelProperty(index = 1)
    private String logId;
}
