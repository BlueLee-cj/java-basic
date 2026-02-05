package com.example.lcj.easyexcel;

import java.io.FileNotFoundException;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

/**
 * @author lichengjian
 * @date 2024/6/20
 */
public class Excel {
    public static void main(String[] args) throws FileNotFoundException {
        EasyExcel.read("/Users/lichengjian/Downloads/geo.csv", Model.class, new ExcelListener())
                .excelType(ExcelTypeEnum.CSV).sheet()
                .doRead();
    }
}
