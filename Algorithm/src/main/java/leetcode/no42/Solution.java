package leetcode.no42;

import java.util.Map;

/**
 * @author x
 * @date 2020-04-04
 * @see <href="https://leetcode-cn.com/problems/trapping-rain-water/"/>
 */
public class Solution {

    /**
     * 遍历数组中每个元素，判断当前元素可以承接雨水量
     * 承接雨水量：左边最高及右边最高较小值 - 当前元素值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height.length <= 2) {
            // corner case
            return 0;
        }

        int res = 0;

        for (int i = 1; i < height.length; i++) {
            // 左边最大值
            int leftMax = findMax(height, 0, i);
            // 右边最大值
            int rightMax = findMax(height, i + 1, height.length);
            // 二者较小值
            int min = Math.min(leftMax, rightMax);
            // 累加承接雨水量
            if (min > height[i]) {
                res += min - height[i];
            }
        }

        return res;

    }

    private int findMax (int[] origin, int startIdx, int endIdx) {

        if (startIdx >= endIdx) {
            return 0;
        }

        int max = 0;
        for (int i = startIdx; i < endIdx; i++) {
            if (origin[i] > max) {
                max = origin[i];
            }
        }

        return max;
    }

    /**
     * 减少冗余遍历，维护每个节点的左边和右边最大值
     * 动态规划——状态转移方程：当前节点左边最大值 = max(当前节点左边节点左边最大值， 当前节点左边节点)
     *
     * @param height
     * @return
     */
    public int trapV2(int[] height) {

        if (height.length <= 2) {
            // corner case
            return 0;
        }

        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];

        //
        for (int i = 1; i < leftMaxArr.length; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i - 1], height[i - 1]);
        }

        for (int i = rightMaxArr.length - 2; i > 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], height[i + 1]);
        }

        int res = 0;

        for (int i = 1; i < height.length; i++) {
            // 二者较小值
            int min = Math.min(leftMaxArr[i], rightMaxArr[i]);
            // 累加承接雨水量
            if (min > height[i]) {
                res += min - height[i];
            }
        }

        return res;

    }

}
