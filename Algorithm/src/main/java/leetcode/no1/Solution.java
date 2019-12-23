package leetcode.no1;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode-cn.com/problems/two-sum/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></a>
 */
public class Solution {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表 两次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remained = target - nums[i];
            if (map.containsKey(remained) && i != map.get(remained)) {
                return new int[] {i, map.get(remained)};
            }
        }
        return null;
    }

    /**
     * 哈希表 两次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int remained = target - nums[i];
            if (map.containsKey(remained) && i != map.get(remained)) {
                return new int[] {i, map.get(remained)};
            }
        }
        return null;
    }

}
