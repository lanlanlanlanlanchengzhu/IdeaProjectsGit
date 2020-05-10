package leetcode.no236;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author x
 * @date 2020-05-11
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque dequeP = new LinkedList();
        Deque dequeQ = new LinkedList();
        getRootPath(root, p, dequeP);
        getRootPath(root, q, dequeQ);
        Iterator iteratorP = dequeP.descendingIterator();
        while (iteratorP.hasNext()) {
            TreeNode treeNodeP = (TreeNode) iteratorP.next();
            Iterator iteratorQ = dequeQ.descendingIterator();
            while (iteratorQ.hasNext()) {
                TreeNode treeNodeQ = (TreeNode) iteratorQ.next();
                if (treeNodeP.equals(treeNodeQ)) {
                    return treeNodeP;
                }
            }
        }
        return null;
    }

    /**
     * 获取从根节点到指定节点的路径
     * 头->尾：跟->当前节点
     *
     * @param root
     * @param target
     * @param rootPath
     */
    private boolean getRootPath(TreeNode root, TreeNode target, Deque rootPath) {

        if (root == null) {
            return false;
        }
        boolean found = false;
        rootPath.addLast(root);
        if (target.equals(root)) {
            found = true;
        }
        if (!found && root.left != null) {
            found = getRootPath(root.left, target, rootPath);
        }
        if (!found && root.right != null) {
            found = getRootPath(root.right, target, rootPath);
        }
        if (!found) {
            // ！！！只有当前节点及其子节点全部未找到时，才删除此节点，不能直接删除
            rootPath.removeLast();
        }

        return found;
    }

}
