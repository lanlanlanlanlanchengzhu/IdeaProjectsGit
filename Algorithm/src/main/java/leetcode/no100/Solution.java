package leetcode.no100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public String preOrder;
    public Integer index;
    public TreeNode root;

    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
        public TreeNode() {
        }
    }

    public List<Integer> mediumPrint (TreeNode treeNode, List res) {
        if (null == treeNode) {
            return res;
        }

        mediumPrint(treeNode.left, res);

        res.add(treeNode.val);

        mediumPrint(treeNode.right, res);

        return res;
    }


    public List<Integer> prePrint (TreeNode treeNode, List res) {
        if (null == treeNode) {
            return res;
        }

        res.add(treeNode.val);

        mediumPrint(treeNode.left, res);

        mediumPrint(treeNode.right, res);

        return res;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List pPre = new ArrayList();
        mediumPrint(p, pPre);

        List qPre = new ArrayList();
        mediumPrint(p, qPre);

        List pMedium = new ArrayList();
        mediumPrint(p, pMedium);

        List qMedium = new ArrayList();
        mediumPrint(p, qMedium);

        return Objects.equals(pPre, qPre) && Objects.equals(pMedium, qMedium);
    }

    public void init (String preOrder) {
        // 初始化
        this.preOrder = preOrder;

        index = 0;

        root = null;

        /*List<TreeNode> treeNodes = new ArrayList<>();

        for (int i=0; i < preOrder.length(); i++) {

        }*/

    }

    public void createBinTree (TreeNode root) {

        if (index > preOrder.length()) {
            return;
        }

        if (preOrder.charAt(index) == '#') {
            // 空节点
               root = null;
            index++;
        } else {
            root = new TreeNode();
            root.val = preOrder.charAt(index);
            index++;
            createBinTree(root.left);
            createBinTree(root.right);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.next());
//        String preOrder = scanner.next();
        String preOrder = "a#b#cdef#####a##";

        Solution solution = new Solution();
        solution.init(preOrder);
        solution.createBinTree(solution.root);
        solution.isSameTree(null, null);
    }

}
