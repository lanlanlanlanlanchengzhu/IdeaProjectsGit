package leetcode.no57;

/**
 * @see <href="https://leetcode-cn.com/problems/insert-interval/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></href="">
 */
public class Solution {

    /**
     * 先进行一次遍历，确认直接插入/合并插入
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // corner case
        if (intervals.length <= 0) {
            return new int[][]{newInterval};
        }

        int insertStartIdx = intervals.length - 1;
        int insertEndIdx = intervals.length - 1;

        int start = newInterval[0];
        int end = newInterval[newInterval.length - 1];

        // 默认插入已存在区间
        boolean intervalFlagStart = false;
        boolean intervalFlagEnd = false;

        for (int i = 0; i < intervals.length; i++) {
            if (start < intervals[i][0]) {
                // intervals数组为递增序列
                // intervalFlagStart为true标识插入间隙
                intervalFlagStart = true;
                insertStartIdx = i;
                break;
            }
            if (start <= intervals[i][intervals[i].length - 1]) {
                insertStartIdx = i;
                break;
            }
        }

        for (int i = 0; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                // intervals数组为递增序列
                // intervalFlagStart为true标识插入间隙
                intervalFlagEnd = true;
                insertEndIdx = i;
                break;
            }
            if (end <= intervals[i][intervals[i].length - 1]) {
                insertEndIdx = i;
                break;
            }
        }

        // 返回结果
        int[][] res = new int[intervals.length + 1][];
        for (int i = 0; i <= insertStartIdx; i++) {
            res[i] = intervals[i];
        }
        int[] newNode = new int[2];
        if (intervalFlagStart) {
            // 插入区间不在已存在区间内，插入区间开始元素作为新节点开始元素
            if (intervalFlagEnd) {
                // 新插入节点头元素所在节点头元素作为头，新插入节点尾元素所在节点尾元素作为尾
                newNode[0] = intervals[insertStartIdx][0];
                newNode[1] = intervals[insertEndIdx][ intervals[insertEndIdx].length - 1] > end ? intervals[insertEndIdx][ intervals[insertEndIdx].length - 1] : end;
            } else {
                // 插入节点头+插入节点尾元素所在节点尾元素
                newNode[0] = start;
                newNode[1] = intervals[insertEndIdx][ intervals[insertEndIdx].length - 1] > end ? intervals[insertEndIdx][ intervals[insertEndIdx].length - 1] : end;
            }
        } else {
            // 插入区间在已存在区间内，插入区间头元素所在节点头元素作为新节点开始元素
            if (intervalFlagEnd) {
                // 新插入节点头元素所在节点作为头，新插入节点尾元素作为尾
                newNode[0] = intervals[insertStartIdx][0];
                newNode[1] = end;
            } else {
                // 新插入节点分别作为头和尾
                newNode[0] = start;
                newNode[1] = end;
            }
        }

        // 插入元素
        res[insertStartIdx] = newNode;

        // 补齐后续节点
        int endTemp = intervalFlagEnd ? insertEndIdx : insertEndIdx + 1;
        for (int i = endTemp, j = 1; i < intervals.length; i++, j++) {
            res[insertStartIdx + j] = intervals[endTemp];
        }

        int count = 0;
        for (int[] temp : res) {
            if (temp != null) {
                count++;
            }
        }

        int[][] actualRes = new int[count][];

        for (int i = 0; i < count; i++) {
            actualRes[i] = res[i];
        }

        return actualRes;
    }

}
