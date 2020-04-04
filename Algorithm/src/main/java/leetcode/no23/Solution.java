package leetcode.no23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <gref="https://leetcode-cn.com/problems/merge-k-sorted-lists/"></gref="">
 */
public class Solution {

    /**
     * 合并多个有序链表
     *
     * 1 将链归集到数组
     * 2 对数组进行排序
     * 3 将数组转换为链表
     *
     * 时间复杂度 O(n + nlgn + n) = O(nlgn)
     * 空间复杂度 O(n)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 数组大小
        int count = 0;
        for (ListNode oneListNode : lists) {
            while (oneListNode != null) {
                count++;
                oneListNode = oneListNode.next;
            }
        }

        // 1 将链归集到数组
        int[] listNodes = new int[count];
        count = 0;
        for (ListNode oneListNode : lists) {
            while (oneListNode != null) {
                listNodes[count] = oneListNode.val;
                count++;
                oneListNode = oneListNode.next;
            }
        }

        // 2 对数组进行排序
        Arrays.sort(listNodes);

        // 3 将数组转换为链表
        ListNode head = null;
        ListNode curr = null;
        for (int i = 0; i < listNodes.length; i++) {
            ListNode listNode = new ListNode(listNodes[i]);
            if (i == 0) {
                curr = listNode;
                head = curr;
            } else {
                curr.next = listNode;
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 合并多个有序链表
     *
     * 逐一比较，每次选取最小的元素
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsV1(ListNode[] lists) {
        ListNode[] idxArr = new ListNode[lists.length];

        for (int i = 0; i < lists.length; i++) {
            idxArr[i] = lists[i];
        }

        ListNode head = null;
        ListNode curr = null;

        // 遍历所有链表
        boolean flag = false;
        for (int i = 0; i < idxArr.length; i++) {
            if (idxArr[i] != null) {
                flag = true;
                break;
            }
        }

        while (flag) {
            // 找出每个有序链表中最小的元素
            flag = false;

            // 找出最小元素下标
            int idx = -1;
            int idxVal = Integer.MAX_VALUE;
            for (int i = 0; i < idxArr.length; i++) {
                if (idxArr[i] != null && idxArr[i].val < idxVal) {
                    idx = i;
                    idxVal = idxArr[i].val;
                }
            }
            // 更新下标
            idxArr[idx] = idxArr[idx].next;
            // 保存至链表
            ListNode listNode = new ListNode(idxVal);
            if (head == null) {
                // 头节点
                curr = listNode;
                head = curr;
            } else {
                curr.next = listNode;
                curr = curr.next;
            }

            // 判断是否遍历完成
            for (int i = 0; i < idxArr.length; i++) {
                if (idxArr[i] != null) {
                    flag = true;
                    break;
                }
            }

        }

        return head;
    }

    /**
     * 优先队列 / 优先队列也可以用最小堆替换
     * 队列大小为数组大小
     * 队列中维护每个有序列表中首元素，每次从队列出队，同时将后续节点入队
     *
     * 时间复杂度 O(nlgk) k为数组数量 n为总元素数量
     * 空间复杂度 O(n)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsV2(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 返回结果
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;

        // 构建优先队列
        // corner case 优先队列构造函数初始大小不能小于1
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val < o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < lists.length; i++) {
            // corner case 数组中元素为null
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }

        while (!priorityQueue.isEmpty()) {
            // 出队，将出队元素拼接到结果列表中
            curr.next = priorityQueue.poll();
            curr = curr.next;

            // 当前队列下一元素入队
            if (curr.next != null) {
                priorityQueue.add(curr.next);
            }
        }

        return head.next;
    }

    /**
     * 归并排序思想
     * 将已经排序好子链表归并
     * 递归
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsV3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsInternal(lists)[0];
    }

    /**
     * 递归函数 每次返回结果为原数组一半大小
     *
     * @param lists
     * @return
     */
    private ListNode[] mergeKListsInternal(ListNode[] lists) {
        // 递归出口 数组中仅包含一个元素
        if (lists.length <= 1) {
            return lists;
        }

        ListNode[] afterMerge = new ListNode[(lists.length + 1) / 2];

        // 将数组中链表两两归并
        for (int i = 0; i < lists.length / 2; i++) {
            afterMerge[i] = mergeTwoLists(lists[i], lists[lists.length - 1 - i]);
        }

        // 奇数
        // 取余
        if (lists.length % 2 == 1) {
            afterMerge[(lists.length + 1) / 2 - 1] = lists[(lists.length + 1) / 2 - 1];
        }

        return mergeKListsInternal(afterMerge);
    }

    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
            p = p.next;
        }
        if (l2 != null) {
            p.next = l2;
            p = p.next;
        }
        return head.next;
    }

}
