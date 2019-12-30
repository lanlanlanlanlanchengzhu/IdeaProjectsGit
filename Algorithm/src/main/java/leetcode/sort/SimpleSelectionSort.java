package leetcode.sort;

/**
 * 简单选择排序
 * 每次遍历确定第n小的元素位置，并进行交换
 */
public class SimpleSelectionSort {

    public void sort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int min = source[i];
            int idx = -1;
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < min) {
                    min = source[j];
                    idx = j;
                }
            }
            if (idx != -1) {
                int temp = source[i];
                source[i] = source[idx];
                source[idx] = temp;
            }
        }
    }

}
