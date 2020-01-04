package leetcode.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort (int[] origin) {
        sortInternal(origin, 0, origin.length - 1);
    }

    private void sortInternal(int[] origin, int start, int end) {
        // 递归出口
        if (start >= end) {
            return;
        }

        int i = start, j = end, temp = origin[i];
        while (i < j) {
            // 从后向前 找到第一个小于标志位的下标
            while (i < j && origin[j] > temp) {
                j--;
            }
            if (i < j) {
                // 赋值后指针后移
                origin[i] = origin[j];
                i++;
            }
            // 从前向后 找到第一个大于标志位的下标
            while (i < j && origin[i] < temp) {
                i++;
            }
            if (i < j) {
                // 赋值后指针前移
                origin[j] = origin[i];
                j --;
            }
        }
        // i=j
        origin[i] = temp;
        sortInternal(origin, start, i -1);
        sortInternal(origin, i + 1, end);
    }
}
