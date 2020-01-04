package leetcode.no141;

import java.util.HashSet;
import java.util.Set;

/**
 * @see
 */
public class Solution {

    /**
     * 遍历，记录遍历过的节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)   辅助存储空间
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        // 存储所有遍历过节点
        // 注意！此处用对象，不通对象，可能val一样
        Set<ListNode> lookup = new HashSet<>();
        lookup.add(head);

        while (head.next != null) {
            head = head.next;
            if (lookup.contains(head)) {
                return true;
            } else {
                lookup.add(head);
            }
        }

        return false;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycleDoublePoniter(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode singlePointer = head, doublePointer = head.next;

        // 如果存在环路，迟早会相等
        while (singlePointer != doublePointer) {
            if (doublePointer == null || doublePointer.next == null) {
                // 双指针先到达终点
                return false;
            }
            singlePointer = singlePointer.next;
            doublePointer = doublePointer.next.next;
        }

        return true;
    }

}
