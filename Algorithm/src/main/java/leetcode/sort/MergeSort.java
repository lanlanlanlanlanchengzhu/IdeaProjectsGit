package leetcode.sort;

/**
 * 归并排序
 * 稳定性排序
 *
 * 分治思想：将问题拆解为子块排序，然后将排序好的子块进行合并
 *
 * 升序
 */
public class MergeSort {

    public int[] sort(int[] source) {
        return sortInternal(source, 0, source.length - 1);
    }

    private int[] sortInternal(int[]source, int start, int end) {
        // 分——将问题拆解为子问题
        // 递归出口
        if (end - start == 0) {
            return new int[]{source[start]};
        }
        if (end - start == 1) {
            if (source[start] < source[end]) {
                return new int[]{source[start], source[end]};
            } else {
                return new int[]{source[end], source[start]};
            }
        }
        int[] subA = sortInternal(source, start, start + (end - start) / 2);
        int[] subB = sortInternal(source, start + (end - start) / 2 + 1, end);
        // 合——将已经排序好的子数组合并
        return merge(subA, subB);
    }

    private int[] merge(int[] subA, int[] subB) {
        int idxA = 0, idxB = 0, idxRes = 0;
        int[] res = new int[subA.length + subB.length];
        while (idxA < subA.length && idxB < subB.length) {
            if (subA[idxA] < subB[idxB]) {
                res[idxRes] = subA[idxA];
                idxA++;
            } else {
                res[idxRes] = subB[idxB];
                idxB++;
            }
            idxRes++;
        }
        while (idxA < subA.length) {
            res[idxRes] = subA[idxA];
            idxA++;
            idxRes++;
        }
        while (idxB < subB.length) {
            res[idxRes] = subB[idxB];
            idxB++;
            idxRes++;
        }
        return res;
    }
}
