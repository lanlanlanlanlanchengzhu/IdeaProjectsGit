package leetcode.no1288;

import java.util.Arrays;

/**
 * @author x
 * @date 2020-05-08
 */
public class Solution {

    /**
     * 按左边坐标升序，右边坐标降序排列
     * 只有当前右边坐标比其右节点右边节点大时，才会发生覆盖
     *
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {

        // lambda表达式，Comparator接口：返回负数是升序排列；返回正数是降序排列
        // 左边左边升序，右边坐标降序
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int length = intervals.length, count = length;
        int max = intervals[0][1];

        for (int i = 1; i < length; i++) {
            if (max >= intervals[i][1]) {
                // 发生覆盖
                count--;
            }
            max = Math.max(max, intervals[i][1]);
        }

        return count;
    }

}
