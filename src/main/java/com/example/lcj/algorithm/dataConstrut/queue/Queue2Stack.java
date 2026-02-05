package com.example.lcj.algorithm.dataConstrut.queue;

/**
 * 思路同上：有数据队列和辅助队列，模拟栈的先进后出，队列是队尾进队头出，
 * 也就是说每次取值要取队列的队尾元素，数据队列出队到辅助队列，留下最后一个元素返回，辅助队列再把元素出队到数据队列
 */
public class Queue2Stack {
    /**
     * 用队列的入队和出队
     * 来实现栈的入栈和出栈
     * */
    
    java.util.Queue queue1 = new java.util.LinkedList();//主要存放数据
    java.util.Queue queue2 = new java.util.LinkedList();//辅助
    
    public void push(Object o) {
        queue1.add(o);
    }
    
    public Object pop() {
        Object o = null;
        while(queue1.size()>1) {
            queue2.add(queue1.poll());
        }
        if(queue1.size()==1) {
            o = queue1.poll();
            while(queue2.size()>0) {
                queue1.add(queue2.poll());
            }
        }
        
        return o;
    }
    
    public int length() {
        return queue1.size();
    }
    

}