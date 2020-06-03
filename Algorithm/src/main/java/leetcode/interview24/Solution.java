package leetcode.interview24;

import leetcode.ListNode;

/**
 * @author x
 * @date 2020-05-11
 * @see <href="https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/"></>
 */
public class Solution {

    /**
     * 指针反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseListReverse(ListNode head) {

        if (head == null || head.next == null) {
            // 最后一个节点，返回最后结果的头节点
            return head;
        }

        ListNode res = reverseListReverse(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

}
