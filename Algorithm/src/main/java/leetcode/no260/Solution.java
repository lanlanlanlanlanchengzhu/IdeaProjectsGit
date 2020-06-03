package leetcode.no260;

import java.util.HashSet;
import java.util.Set;

/**
 * @author x
 * @date 2020-05-15
 */
public class Solution {

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet(2);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int[] res = new int[2];
        int count = 0;
        for (Integer num : set) {
            res[count] = num;
            count++;
        }
        return res;
    }

}
