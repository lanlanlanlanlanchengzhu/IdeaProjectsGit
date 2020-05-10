package leetcode.no725;

import leetcode.ListNode;

import java.util.Objects;

/**
 * @author x
 * @date 2020-05-04
 */
public class Solution {

    /**
     * 注意for循环中i++ ++i
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] res = new ListNode[k];

        // 获取总长度
        ListNode curr = root;
        int length = 0;
        while (!Objects.isNull(curr)) {
            curr = curr.next;
            length++;
        }

        // 每组个数，较长组个数
        int width = length / k, proirLength = length % k;

        curr = root;

        // 以结果中每个数组为出发点
        for (int i = 0; i < k; ++i) {
            ListNode head = curr;
            for (int j = 0; j < (i < proirLength ? width + 1 : width) - 1; ++j) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                // 最后一个节点最后一个指针置为null
                ListNode pre = curr;
                curr = curr.next;
                pre.next = null;
            }
            res[i] = head;
        }

        return res;
    }

}
