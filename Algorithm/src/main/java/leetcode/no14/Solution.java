package leetcode.no14;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        int c = 0;
        int maxSunLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < maxSunLen) {
                maxSunLen = strs[i].length();
            }
        }

        boolean flag = false;

        while (c < maxSunLen) {
            char temp = strs[0].charAt(c);
            for (int i = 1; i < strs.length; i++) {
                if (temp != strs[i].charAt(c)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }

            c++;
        }

        if (c >= 1) {
            return strs[0].substring(0, c);
        } else {
            return "";
        }
    }

}
