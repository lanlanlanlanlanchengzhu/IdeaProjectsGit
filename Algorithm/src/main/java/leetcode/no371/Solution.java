package leetcode.no371;

/**
 * @see <href="https://leetcode-cn.com/problems/sum-of-two-integers/solution/li-yong-wei-cao-zuo-shi-xian-liang-shu-qiu-he-by-p/"></href="">
 */
public class Solution {

    public int getSum(int a, int b) {
        // b->进位
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = temp & b;
            b = b << 1;
        }
        return a;
    }


    public int getSumV1(int a, int b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        if (b >= 0) {
            while (b > 0) {
                b--;
                a++;
            }
        } else {
            while (b < 0) {
                b++;
                a--;
            }
        }
        return a;
    }

}
