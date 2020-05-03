package leetcode.no328;

import leetcode.ListNode;

import java.util.Objects;

/**
 * @author x
 * @date 2020-05-02
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {

        // 奇数
        ListNode oddNode = new ListNode(0);
        ListNode oddPointer = oddNode;
        // 偶数
        ListNode evenNode = new ListNode(0);
        ListNode evenPointer = evenNode;

        boolean oddFlag = true;
        while (head != null) {
            if (oddFlag) {
                // 奇数
                oddPointer.next = head;
                oddPointer = oddPointer.next;
            } else {
                evenPointer.next = head;
                evenPointer = evenPointer.next;
            }
            oddFlag = !oddFlag;
            head = head.next;
        }

        // 处理最后一个节点
        oddPointer.next = null;
        evenPointer.next = null;

        // 拼接
        if (!Objects.isNull(evenNode.next)) {
            oddPointer.next = evenNode.next;
        }

        return oddNode.next;
    }

}
