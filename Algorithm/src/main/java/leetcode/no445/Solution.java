package leetcode.no445;

import java.util.List;

/**
 * @author x
 * @date 2020-04-04
 * @see <href="https://leetcode-cn.com/problems/add-two-numbers-ii/"/>
 */
public class Solution {

    /**
     * 先将链表反转，然后逐位计算
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        int jinwei = 0;

        ListNode pointer = new ListNode(0);
        ListNode resNode = pointer;

        while (l1 != null && l2 != null) {

            int v1 = l1.val;
            int v2 = l2.val;

            int addRes = v1 + v2 + jinwei;
            if (addRes >= 10) {
                addRes = addRes % 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }

            ListNode listNode = new ListNode(addRes);
            pointer.next = listNode;
            pointer = pointer.next;

            l1 = l1.next;
            l2 = l2.next;

        }

        // 处理l1未遍历完成
        while (l1 != null) {

            int addRes = l1.val + jinwei;
            if (addRes >= 10) {
                addRes = addRes % 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }

            ListNode listNode = new ListNode(addRes);
            pointer.next = listNode;
            pointer = pointer.next;

            l1 = l1.next;

        }

        // 处理l2未遍历完成
        while (l2 != null) {
            int addRes = l2.val + jinwei;
            if (addRes >= 10) {
                addRes = addRes % 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }

            ListNode listNode = new ListNode(addRes);
            pointer.next = listNode;
            pointer = pointer.next;

            l2 = l2.next;

        }

        // 处理最后一个进位
        if (jinwei == 1) {
            ListNode listNode = new ListNode(1);
            pointer.next = listNode;
            pointer = pointer.next;
        }

        return reverse(resNode.next);

    }

    /**
     * 链表反转
     * 需要三个指针：pre curr next
     * @return
     */
    private ListNode reverse(ListNode node) {

        // 递归出口
        if (node == null || node.next == null) {
            return node;
        }

        ListNode pre = null;
        ListNode next = null;

        while (node != null) {
            next = node.next;

            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }

}
