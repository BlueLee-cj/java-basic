package com.example.lcj.algorithm;

import com.example.lcj.algorithm.dataConstrut.link.LinkedList;

class Solution {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d)
        {
            data = d;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
