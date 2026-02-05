package com.example.lcj.algorithm.dataConstrut.link;

// Simple Java program to find n'th node from end of linked list
class LinkedList2 {
    Node head; // head of the list

    /* Linked List node */
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*
     * Function to get the nth node from the last of a
     * linked list
     */

    /**
     * Method 1 (Use length of linked list)
     * 1) Calculate the length of Linked List. Let the length be len.
     * 2) Print the (len – n + 1)th node from the beginning of the Linked List.
     *
     * @param n
     */
    void printNthFromLast1(int n) {
        int len = 0;
        Node temp = head;

        // 1) count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // check if value of n is not more than length of
        // the linked list
        if (len < n)
            return;

        temp = head;

        // 2) get the (len-n+1)th node from the beginning
        for (int i = 1; i < len - n + 1; i++)
            temp = temp.next;

        System.out.println(temp.data);
    }

    /* Function to get the nth node from end of list */

    /**
     * Maintain two pointers – reference pointer and main pointer.
     * Initialize both reference and main pointers to head.
     * First, move reference pointer to n nodes from head.
     * Now move both pointers one by one until the reference pointer reaches the end.
     * Now the main pointer will point to nth node from the end. Return the main pointer.
     *
     * @param n
     */
    void printNthFromLast2(int n) {
        Node main_ptr = head;
        Node ref_ptr = head;

        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref_ptr == null) {
                    System.out.println(n + " is greater than the no "
                            + " of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }
            while (ref_ptr != null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. " + n + " from last is " + main_ptr.data);
        }
    }


    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /*
         * 1 & 2: Allocate the Node &
         * Put in the data
         */
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Driver program to Test above methods */
    public static void main(String[] args) {
        LinkedList2 llist = new LinkedList2();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);

        llist.printNthFromLast1(4);
    }
} // This code is contributed by Rajat Mishra

