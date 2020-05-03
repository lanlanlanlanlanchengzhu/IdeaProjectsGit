package leetcode.interview1;


import leetcode.ListNode;

/**
 * @author x
 * @date 2020-04-11
 * @see <href="https://leetcode-cn.com/problems/linked-list-cycle-lcci/"/>
 */
public class Solution {

    /**
     * 判断链表是否有环，如果有环返回环中首个节点
     *
     * 解题思路；两个指针，快指针每次走两格，慢指针每次走一格，快指针到达重点则表明无环
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode low = new ListNode(0);
        ListNode fast = new ListNode(0);
        low = head;
        fast = head.next;

        while (fast != low) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            low = low.next;
        }

        // 此时fast == low，两点相遇
        // fast移动到链表表头
        // fast和low每次移动一个节点，相遇点即为环中首节点
        fast = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }

        return head;
    }

}
