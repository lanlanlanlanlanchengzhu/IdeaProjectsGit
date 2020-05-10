package leetcode.no19;

import leetcode.ListNode;

import java.util.Objects;

/**
 * @author x
 * @date 2020-05-04
 */
public class Solution {

    /**
     * 核心思想：一次遍历，长度为n的滑动窗口
     * dummy：虚拟节点!!!
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode headlPointer = dummy;
        ListNode tailPointer = dummy;
        // 二者间隔为n+1
        while (n + 1 > 0) {
            tailPointer = tailPointer.next;
            n--;
        }

        // 找到倒数第n个节点
        while (!Objects.isNull(tailPointer)) {
            tailPointer = tailPointer.next;
            headlPointer = headlPointer.next;
        }

        // 删除
        headlPointer.next = headlPointer.next.next;

        return dummy.next;
    }

}
