package leetcode.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 交换排序
     * 稳定排序
     * 升序——每一次冒泡确认最大值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param origin
     * @return
     */
    public void bubble(int[] origin) {

        // 操作n次
        for (int i = 0; i < origin.length; i++) {
            // 每次遍历确认最大值
            for (int j = 0; j < origin.length - 1 - i; j++) {
                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 交换排序
     * 稳定排序——相同元素的前后顺序并没有改变
     * 升级版本——标识位
     * 升序——每一次冒泡确认最大值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param origin
     * @return
     */
    public void bubbleV1 (int[] origin) {

        int i = 0;
        // boolean类型默认值为false
        boolean flag = true;
        while (i < origin.length - 1 && flag) {
            // 先置为false
            flag = false;
            i++;
            for (int j = 0; j < origin.length - 1; j++) {
                if (origin[j] > origin[j + 1]) {
                    // 发生交换，将flag置为true
                    flag = true;
                    int temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 交换排序
     * 稳定排序——相同元素的前后顺序并没有改变
     * 升级版本——鸡尾酒排序，每次遍历确认最小值及最大值
     * 升序——每一次冒泡确认最大值
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param origin
     * @return
     */
    public void bubbleV2 (int[] origin) {

        int left = 0, right = origin.length - 1;
        while (left < right) {
            // 从前向后，确认最大值
            for (int i = left; i < right; i++) {
                if (origin[i] > origin[i + 1]) {
                    int temp = origin[i];
                    origin[i] = origin[i + 1];
                    origin[i + 1] = temp;
                }
            }
            left++;
            // 从后向前，确认最小值
            for (int i = right; i > left; i--) {
                if (origin[i] < origin[i - 1]) {
                    int temp = origin[i];
                    origin[i] = origin[i - 1];
                    origin[i - 1] = temp;
                }
            }
            right--;
        }

    }

}
