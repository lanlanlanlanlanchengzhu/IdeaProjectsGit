package leetcode.no3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @see <href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/"></href="">
 */
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

    /**
     * 暴力解法——通过
     * 时间复杂度：O(n^2*lgn)
     * 空间复杂度：
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV1(String s) {
        if (s.length() <= 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> used = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                // 集合中存在重复，表示子串已经有重复元素
                if (!used.add(s.charAt(j))) {
                    break;
                }
            }
            // 记录最长子串长度
            if (used.size() > res) {
                res = used.size();
            }
        }

        return res;
    }

    /**
     * 滑动窗口，窗口只会增大
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV2(String s) {
        if (s.length() <= 0) {
            return 0;
        }

        int left = 0, max = 0;
        Map<Character, Integer> used = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (used.containsKey(s.charAt(i))) {
                // 当前元素已经存在，更新最左下标（下一元素存在于子串中间）
                left = Math.max(left, used.get(s.charAt(i)) + 1);
            }
            // 将当前元素对应下标更新
            used.put(s.charAt(i), i);
            // 更新最长子串长度
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

}
