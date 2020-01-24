package leetcode.no424;

/**
 * @see <href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/"></href="">
 */
public class Solution {

    /**
     * 滑动窗口
     *
     *
     * @param s 原始字符串
     * @param k 允许转换次数
     * @return
     */
    public int characterReplacement(String s, int k) {

        if (s.length() <= 0) {
            return 0;
        }

        int left = 0;
        int[] countArr = new int[26];
        // 数组中元素最多的元素对应的数量
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            // 判断将右侧指针右移后，窗口增大 or 窗口右移
            countArr[s.charAt(right) - 'A']++;
            // 是否更新窗口中元素数量最大值
            max = Math.max(max, countArr[s.charAt(right) - 'A']);

            // 判断窗口移动情况
            if (max + k >= right - left + 1) {
                // 窗口增大
            } else {
                // 窗口右移
                countArr[s.charAt(left) - 'A']--;
                left++;
            }

        }

        // 最终结果为窗口大小
        return s.length() - left;
    }

}
