package leetcode;

/**
 * @author x
 * @date 2020-05-20
 */
public class ListCycle {

    public boolean listCycle (ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode low = head;
        ListNode fast = head.next.next;
        while (fast != low) {
            if (fast == null || low == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }

}
