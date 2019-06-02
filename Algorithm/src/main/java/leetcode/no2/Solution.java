package leetcode.no2;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        print(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // split add
        int addRes1 = listNode2Number(revert(l1));
        int addRes2 = listNode2Number(revert(l2));
        int addRes = addRes1 + addRes2;
        // transfer
        return number2ListNode(addRes);
    }

    public int listNode2Number (ListNode source) {
        ListNode backUp = source;
        int count = 1;
        while (backUp.next != null) {
            count++;
            backUp = backUp.next;
        }
        int res = 0;
        while (count > 0) {
            count--;
            res += source.val * Math.pow(10, count);
            source = source.next;
        }
        return res;
    }

    public static void print (ListNode printSource) {
        System.out.println(printSource.val);
        if (printSource.next != null) {
            print(printSource.next);
        } else {
            return;
        }
    }

    public ListNode number2ListNode (int number) {
        int i = 1;
        while (number >= Math.pow(10, i)) {
            i++;
        }
        ListNode finalRes = new ListNode(0);
        ListNode res = finalRes;
        while (i > 0) {
            i--;
            int oneNumber = number % 10;
            number = number / 10;
            res.next = new ListNode(oneNumber);
            res = res.next;
        }
        finalRes = finalRes.next;
        return finalRes;
    }

    public ListNode revert (ListNode source) {

        if (source == null || source.next == null) {
            return source;
        }
        ListNode prev = source;
        ListNode curr = source.next;
        ListNode temp = source.next.next;

        // 循环直至遍历完链表
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        source.next = null;

        return prev;
    }

}
