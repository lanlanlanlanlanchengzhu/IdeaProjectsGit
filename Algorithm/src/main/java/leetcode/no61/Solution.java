package leetcode.no61;

import leetcode.ListNode;

import java.util.Objects;

/**
 * @author x
 * @date 2020-05-03
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (Objects.isNull(head)) {
            return head;
        }

        ListNode tempHead = head;

        int length = 0;
        while (!Objects.isNull(tempHead)) {
            tempHead = tempHead.next;
            length++;
        }

        k = k % length;

        while (k > 0 ) {
            head = rotateOnce(head);
            k--;
        }
        return head;
    }

    private ListNode rotateOnce (ListNode head) {

        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode res = new ListNode(0);
        ListNode tempHead = head;

        // 找到倒数第二个节点
        while (!Objects.isNull(head.next.next)) {
            head = head.next;
        }

        // 记录最后一个节点
        ListNode finalNode = head.next;
        // 倒数第二个节点尾指针置空
        head.next = null;

        // 尾节点作为首节点
        res.next = finalNode;
        // 尾节点下一节点为原首节点
        finalNode.next = tempHead;

        return res.next;
    }

}
