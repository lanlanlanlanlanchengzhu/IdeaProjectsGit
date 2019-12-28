package leetcode.no338;

public class Solution {

    public int[] countBits(int num) {
        int[] res = new int[num];
        for (int i = 1; i < num; i++) {
            res[i] = i & (i - 1) + 1;
        }
        return res;
    }

}
