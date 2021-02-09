import leetcode.ListNode;

/**
 * @author x
 * @date 2020-08-22
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    // 升序
    private static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return mergeTow(head, head.next);
        }

        ListNode low = head;
        ListNode fast = head.next;
        while (fast == null || fast.next == null) {
            // 找到mid
            fast = fast.next.next;
            low = low.next;
        }
        low.next = null;

        return mergeTow(mergeSort(head), mergeSort(low));

    }

    private static ListNode mergeTow(ListNode listNode1, ListNode listNode2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val > listNode2.val) {
                curr.next = listNode1;
                curr = curr.next;
                listNode1 = listNode1.next;
            } else {
                curr.next = listNode2;
                curr = curr.next;
                listNode2 = listNode2;
            }
        }

        if (listNode1 == null) {
            curr.next = listNode2;
        }

        if (listNode2 == null) {
            curr.next = listNode1;
        }

        return dummy.next;
    }

}
