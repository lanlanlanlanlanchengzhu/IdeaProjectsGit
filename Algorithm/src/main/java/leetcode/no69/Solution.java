package leetcode.no69;

/**
 * @author x
 * @date 2020-05-10
 */
public class Solution {

    public int mySqrt(int x) {
        int l = 0, r = x, res = -1;

        while (l <= r) {
            int mid = l + (r -l) / 2;
            if ((long)mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

}
