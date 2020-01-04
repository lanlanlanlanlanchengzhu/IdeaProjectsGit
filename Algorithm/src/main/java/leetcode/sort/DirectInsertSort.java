package leetcode.sort;

/**
 * 直接插入排序
 */
public class DirectInsertSort {

    public int[] sort(int[] source) {
        int[] res = new int[source.length];
        for (int i = 0; i < res.length; i++) {
            // 初始化 支持负数排序
            res[i] = Integer.MIN_VALUE;
        }
        // 针对每一个元素进行插入
        for (int i = 0; i < source.length; i++) {
            sortInternal(source[i], res, i);
        }
        return res;
    }

    private void sortInternal(int tar, int[] source, int currTotal) {
        int idx = currTotal;
        // 当前插入非最大  从后向前移位
        for (int i = currTotal - 1; i >= 0; i--) {
            if(source[i] > tar) {
                source[i + 1] = source[i];
                idx--;
            }
        }
        source[idx] = tar;
    }

}
