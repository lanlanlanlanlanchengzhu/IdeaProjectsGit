package leetcode.no104;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author x
 * @date 2020-05-14
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {return 0;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<TreeNode> set = new HashSet();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            set.add(currNode);
            if (queue.isEmpty() && set.size() > 0) {
                depth++;
                set.forEach((tmpNode) -> {
                    if (tmpNode.left != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.right);
                    }
                });
                set.clear();
            }
        }
        return depth;
    }

}
