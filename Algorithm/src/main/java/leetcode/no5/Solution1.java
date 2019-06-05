package leetcode.no5;

public class Solution1 {

    /**
     * 题目：给定一个字符串 s，找到 s 中最长的回文子串
     *
     * 中心扩展法，由一个位置向两边扩展，若两边元素一致，则亟需扩展
     * 考虑两种情况：
     * 1.aba
     * 2.aa
     */
    public String longestPalindrome(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            // 关于index为i的元素中心扩展
            int l1 = findMaxLen(s, i, i);
            // 关于index为i和i+1的元素中心扩展
            int l2 = findMaxLen(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > (endIndex - startIndex)) {
                endIndex = i + len / 2;
                startIndex = i - (len - 1) / 2;
            }
        }

        // substring 为左边闭区间，右边开区间
        return s.substring(startIndex, endIndex + 1);
    }

    /**
     * 找到以当前index为中心的最长回文子串
     *
     * @param s 源字符串
     * @param start index
     * @param end index
     * @return maxLen
     */
    public int findMaxLen (String s, int start, int end) {
        // 此处有一个小技巧，先判断index，如果不满足，则不会去判断数组中index对应元素是否相等，避免数组越界
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestPalindrome("cbbd"));;
    }

}
