package com.example.lcj.map;

import java.util.HashMap;
import java.util.LinkedList;

public class MapCache {
	private static HashMap<String, Object> map = new HashMap<String, Object>();
		
	private static int capacity = 300;// 缓存上限数量控制，防止内存溢出，采用java队列先进先出机制
	
	private static LinkedList<String> queue = new LinkedList<String>();
	// 简单实现，未做重入锁控制。用于缓存String类型的数据，使用者需要考虑并发下异常的捕获处理
	public synchronized static void putCache(String key, Object value){
		if(map.get(key) != null){
			return;
		}
		queue.offer(key);
		map.put(key, value);
		if(queue.size() > capacity){
			String firstKey = queue.removeFirst();
			map.remove(firstKey);
		}
	}
	
	// 简单实现，未做重入锁控制。获取缓存数据，使用者需要考虑并发下异常的捕获处理
	// 未加synchronized同步控制，尽量保证获取数据的效率
	public static Object getCache(String key){
		return map.get(key);
	}
	public static int getSize(){
		return map.size();
	}
	
	public static Object viewFirstValue(){
		if(queue.size() <= 0){
			return null;
		}
		String key = queue.getFirst();
		return map.get(key);
	}
	
	public static Object viewLastValue(){
		if(queue.size() <= 0){
			return null;
		}
		String key = queue.getLast();
		return map.get(key);
	}
	public static void clearCache(){
		map.clear();
	}
}
