package leetcode.no206;

/**
 * @see <href="https://leetcode.com/problems/reverse-linked-list/"></href="">
 *
 * 单链表反转
 *
 * 递归
 * 遍历
 */
public class Solution {

    /**
     * 利用p,q,r三个指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        // corner case 只有一个节点或者链表为空 没有翻转必要
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public ListNode reverseListV1(ListNode head) {

        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, next = null;

        while (head != null) {
            // 分四步
            // 1保存当前节点下一节点
            // 2将当前节点前一节点指定为next
            // 3当前节点指定为前一节点
            // 4当前节点下一节点指定为当前节点

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        // 此时pre节点为当前节点
        return pre;

    }

    public ListNode reverseListRecursive(ListNode head) {

        // 递归出口，找到链表尾元素
        if (head == null || head.next == null) {
            return head;
        }

        ListNode resHead = reverseListRecursive(head.next);
        // 将当前元素下一节点指向前一节点
        head.next.next = head;
        // 避免成环
        head.next = null;

        return resHead;
    }

}
