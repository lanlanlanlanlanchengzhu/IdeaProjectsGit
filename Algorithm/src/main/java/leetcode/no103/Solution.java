package leetcode.no103;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author x
 * @date 2020-05-17
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 层次遍历
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<TreeNode> list = new LinkedList();
        boolean flag = true;
        List<List<Integer>> res = new ArrayList();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr);
            if (queue.isEmpty() && list.size() > 0) {
                // 当前层次遍历完成
                list.forEach((tmpNode) -> {
                    if (tmpNode.left != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.right);
                    }
                });
                List<Integer> oneRes = new ArrayList();
                if (flag) {
                    // 正序
                    while (!list.isEmpty()) {
                        oneRes.add(((LinkedList<TreeNode>) list).pollFirst().val);
                    }
                } else {
                    // 逆序
                    while (!list.isEmpty()) {
                        oneRes.add(((LinkedList<TreeNode>) list).pollLast().val);
                    }
                }
                res.add(oneRes);
                flag = !flag;
                list.clear();
            }
        }
        return res;
    }

}
