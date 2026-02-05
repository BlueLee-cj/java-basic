package com.example.lcj.algorithm.dataConstrut.link;

/**
 * @author lichengjian
 * @date 2022/5/23
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int a) {
        val = a;
        next = null;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    // 2、递归反转整个链表
    // 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 3、反转链表前 N 个节点
    ListNode successor = null;

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    // 4、反转链表的一部分
    // 现在解决我们最开始提出的问题，给一个索引区间 [m, n]（索引从 1 开始），仅仅反转区间中的链表元素。

    ListNode before = null;
    ListNode after = null;

    ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == 1) {
            reverseN(head.next, n);
        }

        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 总结
    // 处理的技巧是：不要跳进递归，而是利用明确的定义来实现算法逻辑。
    // 反转以 a 为头结点的链表
    ListNode reverseX(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    // 判断一个字符串是不是回文串
    boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 在 s 中寻找以 s[left] 和 s[right] 为中心的最长回文串
    String palindrome(String s, int left, int right) {
        // 防止索引越界
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            // 双指针，向两边展开
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left + 1, right);
    }

    /* 倒序打印单链表中的元素值 */
    static void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        // 前序遍历代码
        System.out.println(head.val);

        traverse(head.next);

        // 后序遍历代码
        System.out.println(head.val);
    }

    // 左侧指针
    ListNode left;

    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse1(head);
    }

    boolean traverse1(ListNode right) {
        if (right == null) return true;
        boolean res = traverse1(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        ListNode next1 = new ListNode(1);
        next.next = next1;
        traverse(head);
        System.out.println(head.isPalindrome(head));
    }
}
