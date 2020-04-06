package leetcode.no72;

/**
 * @author x
 * @date 2020-04-06
 * @see <href="https://leetcode-cn.com/problems/edit-distance/"/>
 */
public class Solution {

    /**
     * 动态规划——状态转移方程：d[i][j] = min(d[i][j-1], d[i-1][j], d[i-1][j-1] + (word[i-1][j-1] != word[i][j]))
     *
     * 二维数组注意画图明确和坐标系映射关系
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        if (length1 * length2 == 0) {
            return Math.max(length1, length2);
        }

        int[][] distance = new int[length2 + 1][length1 + 1];

        distance[0][0] = 0;

        // 初始化数组
        for (int i = 1; i <= length1; i++) {
            distance[0][i] = i;
        }

        // 初始化数组
        for (int i = 1; i <= length2; i++) {
            distance[i][0] = i;
        }

        for (int i = 1; i <= length2; i++) {
            for (int j = 1; j <= length1; j++) {
                int needAddOne = word2.charAt(i - 1) == word1.charAt(j - 1) ? 0 : 1;
                distance[i][j] = Math.min(distance[i][j-1] + 1, Math.min(distance[i-1][j] + 1, distance[i-1][j-1] + needAddOne));
            }
        }

        return distance[length2][length1];
    }

}
