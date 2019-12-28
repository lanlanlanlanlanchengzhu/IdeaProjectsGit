package leetcode.no322;

/**
 * @see <href="https://leetcode-cn.com/problems/coin-change/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></href="">
 */
public class Solution {

    /**
     * 动态规划
     * DP[n] = min(DP[n-i]) + 1 // i in coins && min值有效
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 递归中重要思想！！！否则容易执行超时
        // 将最优解缓存
        // !!! amount + 1
        int[] cache = new int[amount + 1];
        return coinChangeInternal(coins, amount, cache);
    }

    private int coinChangeInternal(int[] coins, int remain, int[]cache) {
        // 递归出口-start
        if (remain == 0) {
            return 0;
        }
        if (remain < 0) {
            return -1;
        }
        if (cache[remain] != 0) {
            return cache[remain];
        }
        // 递归出口-end

        // 初始化-一般使用封装类型中最大值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int oneRes = coinChangeInternal(coins, remain - coins[i], cache);
            // -1为无效值
            if (oneRes != -1 && oneRes < min) {
                min = oneRes;
            }
        }
        // 存在有效解
        if (min != Integer.MAX_VALUE) {
            cache[remain] = min + 1;
        } else {
            cache[remain] = -1;
        }
        return cache[remain];
    }

}
