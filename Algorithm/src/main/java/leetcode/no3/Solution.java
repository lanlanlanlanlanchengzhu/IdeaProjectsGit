package leetcode.no3;

public class Solution {

    public static void main(String[] args) {
        String s = "asdasd";
        char[] chars = s.toCharArray();
        s.charAt(0);
        s.length();
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        int length = s.length();
        int maxLength = 1;
        for (int i = 0; i < length - 1; i++) {
            int j = i + 1;
            for (; j < length - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    break;
                }
            }
            if (j - i > maxLength) {
                maxLength = j - i;
            }
        }
        return maxLength;
    }

}
