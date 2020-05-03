package leetcode.no82;

import leetcode.ListNode;

import java.util.Objects;

/**
 * @author x
 * @date 2020-05-02
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode pointer = new ListNode(0);
        ListNode res = pointer;
        int currVal = head.val;
        ListNode pre = head;
        head = head.next;
        int count = 0;

        while (Objects.nonNull(head)) {
            if (currVal == head.val) {
                // 相等
                count++;
            } else {
                if (count > 0) {
                    // 有重复
                } else {
                    // 无重复
                    pointer.next = pre;
                    pointer = pointer.next;
                }
                count = 0;
            }
            currVal = head.val;
            pre = pre.next;
            head = head.next;
        }

        // 处理最后一个节点
        if (count == 0) {
            pointer.next = pre;
            pointer = pointer.next;
        }

        pointer.next = null;

        return res.next;
    }

}
