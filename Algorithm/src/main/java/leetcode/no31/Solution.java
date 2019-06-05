package leetcode.no31;

public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int len = nums.length - 1;
        // 从尾部开始，找第一个小于其后面节点的位置
        int i = findFirst(nums);
        if (i >= 0) {
            // 剩余排序
            sort(nums, i + 1);
        } else {
            sort(nums, 0);
        }
    }

    public int findFirst(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            int j = i + 1;
            while (j <= nums.length - 1) {
                if (nums[j] <= nums[i]) {
                    j++;
                } else {
                    // find exchange
                    // 找出当前i坐标后面最小的数字下标
                    int x = j + 1;
                    while (x <= nums.length - 1) {
                        if (nums[x] < nums[j] && nums[x] > nums[i]) {
                            j = x;
                        }
                        x++;
                    }
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    return i;
                }
            }
            i--;
        }
        return -1;
    }

    public void sort(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1};
        solution.nextPermutation(nums);
        for (int one : nums) {
            System.out.println(one);
        }
    }

}
