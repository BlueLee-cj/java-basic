package com.example.lcj.utils;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;


/**
 *
 * @author lichengjian
 * @date 2024/1/22
 */
@Slf4j
public class ListUtils {

    private ListUtils() {}

    public static <T> T first(final List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T last(final List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> List<T> safeSubList(List<T> list, int start, int end) {
        return start >= list.size()
                ? Collections.emptyList()
                : list.subList(Math.max(start, 0), Math.min(end, list.size()));
    }

    public static <T, R> List<R> buildList(final List<T> list, final Function<T, R> builder) {
        return buildList(list, builder, new ArrayList<>(0));
    }

    public static <T, R> List<R> buildList(
            final List<T> list,
            final Function<T, R> builder,
            final List<R> defaultList) {
        if (CollectionUtils.isEmpty(list) || builder == null) {
            return defaultList;
        }

        final List<R> result = new ArrayList<>(list.size());
        for (T item : list) {
            R r = builder.apply(item);
            if (r != null) {
                result.add(r);
            }
        }

        return result;
    }

    public static <T> boolean contains(List<T> list, T entity, boolean defaultValueIfNull) {
        return list == null ? defaultValueIfNull : list.contains(entity);
    }

    public static <K, V> Map<K, V> toMap(
            final List<V> list,
            final Function<V, K> keyFunction) {
        return toMap(list, keyFunction, null);
    }

    public static <K, V> Map<K, V> toMap(
            final List<V> list,
            final Function<V, K> keyFunction,
            final Predicate<V> predicate) {
        if (CollectionUtils.isEmpty(list) || keyFunction == null) {
            return new HashMap<>(0);
        }

        final Map<K, V> map = Maps.newHashMapWithExpectedSize(list.size());
        for (V item : list) {
            if (predicate != null && !predicate.test(item)) {
                continue;
            }

            K key = keyFunction.apply(item);
            map.put(key, item);
        }
        return map;
    }


    /**
     * 创建指定大小和默认值的list
     *
     * @param size
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> List<T> newList(int size, T defaultValue) {
        if (size <= 0) {
            return new ArrayList<>();
        }

        final List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(defaultValue);
        }
        return list;
    }

    public static <T> T getOrDefault(List<T> list, int index, T defaultValue) {
        if (list == null || index < 0 || list.size() <= index) {
            return defaultValue;
        }
        return list.get(index);
    }

    public static <T> void tryAddIfNotNull(List<T> list, T value) {
        if (list == null || value == null) {
            return;
        }
        list.add(value);
    }

    public static <T> List<T> emptyListIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("111", "22", "33");
        System.out.println(strings.subList(0,1));
    }

}
