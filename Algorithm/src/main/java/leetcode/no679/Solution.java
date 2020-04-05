package leetcode.no679;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author x
 * @date 2020-04-04
 * @see <href="https://leetcode-cn.com/problems/24-game/"/>
 */
public class Solution {

    public boolean judgePoint24(int[] nums) {
        List<Double> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add((double) nums[i]);
        }
        return judgePoint24Internal(numsList);
    }

    /**
     * 24点游戏
     * 回溯法——穷举
     * 先从所有元素中取出前两个，然后将计算结果与剩余n-2的递归进行计算
     *
     * @param nums
     * @return
     */
    public boolean judgePoint24Internal(List<Double> nums) {

        if (nums.size() == 0) {
            return false;
        }
        // 递归出口
        if (nums.size() == 1) {
            // !!!必须用double，且判断条件如下
            // 具体原因暂不清楚...
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }

                // 先取出前两个元素
                double vali = nums.get(i);
                double valj = nums.get(j);

                List<Double> numsSubList = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        // 排除当前元素
                        numsSubList.add(nums.get(k));
                    }
                }

                //四则运算
                for (int k = 0; k < 4; k++) {

                    if (k < 2 && j > i) {
                        // 加法和乘法具有交换性，只需要计算一次即可
                        continue;
                    }

                    double res = 0;
                    if (k == 0) {
                        res = vali + valj;
                    } else if (k == 1) {
                        res = vali * valj;
                    } else if (k == 2) {
                        res = vali - valj;
                    } else if (k == 3) {
                        if (valj != 0) {
                            res = vali / valj;
                        } else {
                            // 除数不能为0
                            continue;
                        }
                    }

                    numsSubList.add(res);
                    // 找到24点时返回成功，否则继续遍历
                    if (judgePoint24Internal(numsSubList)) {
                        return true;
                    }
                    numsSubList.remove(numsSubList.size() - 1);
                }
            }
        }

        // 默认返回结果
        return false;
    }

}
