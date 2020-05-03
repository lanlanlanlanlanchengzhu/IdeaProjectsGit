package leetcode.no24;

import leetcode.ListNode;

/**
 * @author x
 * @date 2020-04-11
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        boolean flag = true;
        ListNode resHeader = new ListNode(0);
        ListNode pre = resHeader;
        ListNode curr = head;
        pre.next = curr;
        while (curr != null) {
            if (flag && curr.next != null) {
                // 换
                pre.next = curr.next;
                curr.next = curr.next.next;
                pre.next.next = curr;

                pre = pre.next;
            } else {
                // 移动
                pre = curr;
                curr = curr.next;
            }
            flag = !flag;
        }
        return resHeader.next;
    }

}
