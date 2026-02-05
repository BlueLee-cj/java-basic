package com.example.lcj.algorithm.dataConstrut.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：lcj
 * @description：
 * 栈中的元素采用 LIFO (Last In First Out)，即后进先出。
 * Push — 在栈的最上方插入元素
 * Pop — 返回栈最上方的元素，并将其删除
 * isEmpty — 查询栈是否为空
 * peek — 返回栈最上方的元素，并不删除
 * @date ：Created in 2020/10/5 13:37
 */
public class Stack {
    // Driver program to Test above functions
    public static void main(String[] args)
    {
        //----------------------------------1-------------------------
        //String exp="231*+9-";
        //System.out.println("postfix evaluation: "+evaluatePostfix(exp));

        //----------------------------------2-------------------------
        //java.util.Stack<Integer> input = new java.util.Stack<Integer>();
        //input.add(34);
        //input.add(3);
        //input.add(31);
        //input.add(98);
        //input.add(92);
        //input.add(23);
        //
        //// This is the temporary stack
        //java.util.Stack<Integer> tmpStack=sortstack(input);
        //System.out.println("Sorted numbers are:");
        //
        //while (!tmpStack.empty())
        //{
        //    System.out.print(tmpStack.pop()+" ");
        //}

        //----------------------------------3-------------------------
        String expr = "([{}])";
        if (areParanthesisBalanced(expr))
            System.out.println("Balanced ");
        else{
            System.out.println("Not Balanced ");
        }
    }

    // function to check if paranthesis are balanced
    static boolean areParanthesisBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    stack.pop();
                    if (x == '{' || x == '[')
                        return false;
                    break;

                case '}':
                    stack.pop();
                    if (x == '(' || x == '[')
                        return false;
                    break;

                case ']':
                    stack.pop();
                    if (x == '(' || x == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    // This function return the sorted stack
    /**
     * Input : [34, 3, 31, 98, 92, 23]
     * Output : [3, 23, 31, 34, 92, 98]
     *
     * Input : [3, 5, 1, 4, 2, 8]
     * Output : [1, 2, 3, 4, 5, 8]
     * @param input
     * @return
     */
    public static java.util.Stack<Integer> sortstack(java.util.Stack<Integer>
                                                   input)
    {
        java.util.Stack<Integer> tmpStack = new java.util.Stack<Integer>();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek()
                    > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }

            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }


    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp)
    {
        //create a stack

        java.util.Stack<Integer> stack=new java.util.Stack<Integer>();

        // Scan all characters one by one
        for(int i=0; i<exp.length(); i++)
        {
            char c=exp.charAt(i);

            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
                stack.push(c - '0');

            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
