package com.example.lcj.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OomService {

    private List<String> data = new ArrayList<>();

    public void addData() {
        // 往同一个ArrayList中不断加入大小为10KB的字符串
        data.add(IntStream.rangeClosed(1, 10_000)
                .mapToObj(__ -> "A")
                .collect(Collectors.joining("")));
    }
}
