package leetcode.no78;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.binaryBit(new int[]{1,2,3});
    }

}
