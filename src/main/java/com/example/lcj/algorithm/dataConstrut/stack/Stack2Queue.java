package com.example.lcj.algorithm.dataConstrut.stack;

/**
 * 1.栈实现队列：思路是有两个栈，一个用来放数据（数据栈），一个用来辅助（辅助栈）。
 * 数据添加时，会依次压人栈，取数据时肯定会取栈顶元素，
 * 但我们想模拟队列的先进先出，所以就得取栈底元素，那么辅助栈就派上用场了，
 * 把数据栈的元素依次弹出到辅助栈，但保留最后一个元素，
 * 最后数据栈就剩下了最后一个元素，直接把元素返回，这时数据栈已经没有了数据。最
 * 后呢，把辅助栈的元素依次压人数据栈，这样，我们成功取到了栈底元素。
 */
public class Stack2Queue {
    /**
     * 用栈的入栈和出栈
     * 来实现队列的入队和出队
     *  stack1是入栈的，stack2是出栈的。
        入队列：直接压入stack1即可
        出队列：如果stack2不为空，把stack2中的栈顶元素直接弹出；
            否则，把stack1的所有元素全部弹出压入stack2中，再弹出stack2的栈顶元素
     * */
    java.util.Stack stack1 = new java.util.Stack();
    java.util.Stack stack2 = new java.util.Stack();
    public void add(Object o) {
        stack1.push(o);
    }
    
    public Object poll() {
        Object o = null;
        
        if(stack2.size()==0) {
            //把stack1的数据放入stack2，留下最后一个数据
            while(stack1.size()>1) {
                stack2.push(stack1.pop());
            }
            if(stack1.size()==1) {
                //把stack1的留下的那个数据返回出去
                o = stack1.pop();
            }
        }else {
            o = stack2.pop();
        }
        
        return o;
    }
    public int length() {
        return stack1.size()+stack2.size();
    }

}