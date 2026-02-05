package com.example.lcj.algorithm.dataConstrut.link;

import java.util.HashSet;

/**
 * @author ：lcj
 * @description：
 * InsertAtEnd — 在链表结尾插入元素
 * InsertAtHead — 在链表开头插入元素
 * Delete — 删除链表的指定元素
 * DeleteAtHead — 删除链表第一个元素
 * Search — 在链表中查询指定元素
 * isEmpty — 查询链表是否为空
 * @date ：Created in 2020/10/5 14:47
 */
public class LinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main1(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    /* Inserts a new Node at front of the list. */
    static public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    // Returns true if there is a loop in linked
    // list else returns false.
    static boolean detectLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        while (h != null) {
            // If we have already hashConstruct this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(h))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);

            h = h.next;
        }

        return false;
    }

    void detectLoop()
    {
        Node slow_p = head, fast_p = head;
        int flag = 0;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop found");
        else
            System.out.println("Loop not found");
    }


    /* Driver program to Test above function */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();

        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;

        if (detectLoop(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");
    }

}


