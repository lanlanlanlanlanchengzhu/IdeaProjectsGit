package leetcode.no70;

/**
 * @see <href="https://leetcode-cn.com/problems/climbing-stairs/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></href="">
 */
public class Solution {

    /**
     * 递归，无缓存，leetcode运行超时
     * 时间复杂度：O(2^n)，树形递归的大小为 2^n
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairsV1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsV1(n -1) + climbStairsV1(n - 2);
    }


    /**
     * 递归，带缓存，通过
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        // 类似斐波那契数列初始元素
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 此处需要注意，数组下标从0开始计算，楼梯数从1开始计算，故申请数组时容量+1
        // 缓存信息，用数组/字典都可以
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return climbStairsInternal(n, cache);
    }

    private int climbStairsInternal(int n, int[] cache) {
        if (cache[n] != 0) {
            return cache[n];
        } else {
            int curr = climbStairsInternal(n -1, cache) + climbStairsInternal(n - 2, cache);
            cache[n] = curr;
            return curr;
        }
    }


    /**
     * 递归，带缓存，通过
     * 简化代码版本
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * !!!注意corner case
     *
     * @param n
     * @return
     */
    public int climbStairsV2(int n) {
        if (n == 1) {
            return 1;
        }
        // 此处需要注意，数组下标从0开始计算，楼梯数从1开始计算，故申请数组时容量+1
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        // 从子问题向上解决，此处可能会存在冗余求解问题（本题不会）
        for (int i = 3; i <= n; i++) {
            res[i] = res[i -1] + res[i -2];
        }
        return res[n];
    }

}
