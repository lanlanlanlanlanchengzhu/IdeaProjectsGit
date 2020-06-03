package leetcode.no151;

import java.util.Stack;

/**
 * @author x
 * @date 2020-05-18
 */
public class Solution151 {

    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            stack.push(" ");
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        while (res.length() > 0) {
            if (" ".charAt(0) == res.charAt(0)) {
                res = res.substring(1, res.length());
            } else {
                break;
            }
        }
        while (res.length() > 0) {
            if (" ".charAt(0) == res.charAt(res.length() - 1)) {
                res = res.substring(0, res.length() - 1);
            } else {
                break;
            }
        }
        return res;
    }

}
