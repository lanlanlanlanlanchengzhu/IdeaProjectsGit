package leetcode.no29;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(2147483647, 1));
    }

    public int divide(int dividend, int divisor) {
        int res = 0;
        int count = divisor;
        int a = dividend;
        int b = divisor;

        if (a >= 0 && b > 0) {
            while (count <= a && res < Integer.MAX_VALUE) {
                count += b;
                res ++;
            }
        } else if (a >= 0 && b < 0) {
            while (a + count >= 0 && res > Integer.MIN_VALUE) {
                count += b;
                res --;
            }
        } else if (a < 0 && b > 0) {
            while (a + count <= 0 && res > Integer.MIN_VALUE) {
                count += b;
                res --;
            }
        } else {
            while (a <= count && res < Integer.MAX_VALUE) {
                count += b;
                res ++;
            }
        }

        return res;
    }

}
