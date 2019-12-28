package leetcode.no338;

/**
 * @see <href="https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/"></href="">
 */
public class Solution {

    /**
     * 暴力解法
     * 时间复杂度：O(nk)
     * 空间复杂度：O(1)
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        // int 类型默认值为 0
        int[] res = new int[num];
        return res;
    }


    /**
     * 动态规划
     * P(x)=P(x/2)+(xmod2)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param num
     * @return
     */
    public int[] countBitsDP(int num) {
        // int 类型默认值为 0
        // 返回结果要从0开始
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res [i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
