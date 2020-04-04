package leetcode.no264;

/**
 * @author x
 * @date 2020-04-03
 * @see <href="https://leetcode-cn.com/problems/ugly-number-ii/"/>
 *
 * 丑数——动态规划，前面最优解作为后面最优解的输入
 * 2, 3. 5
 * 每个丑数为 2^N*3^M*5^P
 *
 * 核心思想：指针及指针后移
 */
public class Solution {

    public int nthUglyNumber(int n) {

        int[] res = new int[n];
        res[0] = 1;

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for (int i = 1; i < n; i++) {
            // 仅支持两两比较
            int min = Math.min(Math.min(2 * res[idx2], 3 * res[idx3]), 5 * res[idx5]);
            // 记录本次动态规划产生记录
            res[i] = min;

            // 指针后移，会有多个指针同时后移的情况，例如 2*3=3*2
            if (min == 2 * res[idx2]) {
                idx2++;
            }
            if (min == 3 * res[idx3]) {
                idx3++;
            }
            if (min == 5 * res[idx5]) {
                idx5++;
            }
        }

        return res[n - 1];
    }

}
