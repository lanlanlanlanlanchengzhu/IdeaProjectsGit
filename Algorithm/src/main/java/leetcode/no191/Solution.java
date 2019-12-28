package leetcode.no191;

/**
 * @see <href="https://leetcode-cn.com/problems/number-of-1-bits/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></href="">
 */
public class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


    public int hammingWeightV1(int n) {
        int count = 0;
        int i = 32;
        while (n != 0 && i > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
            i--;
        }
        return count;
    }


    public int hammingWeightV2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n -1);
            count++;
        }
        return count;
    }

}
