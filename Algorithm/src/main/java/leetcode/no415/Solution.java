package leetcode.no415;

/**
 * @author x
 * @date 2020-05-12
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int num1Len = num1.length(), num2Len = num2.length();
        int jinwei = 0, temp1, temp2;
        while (num1Len > 0 || num2Len > 0) {
            temp1 = (num1Len <= 0) ?  0 : num1.charAt(num1Len - 1) - '0';
            temp2 = (num2Len <= 0) ? 0 : num2.charAt(num2Len - 1) - '0';
            int res = (temp1 + temp2 + jinwei) % 10;
            jinwei =  (temp1 + temp2 + jinwei) / 10;
            sb.insert(0, res);
            num1Len--;
            num2Len--;
        }
        if (jinwei == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("9", "99"));
    }

}
