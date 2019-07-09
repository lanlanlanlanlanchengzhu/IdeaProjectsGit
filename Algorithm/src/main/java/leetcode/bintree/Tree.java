package leetcode.bintree;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Tree {
    private TreeNode root;

    public Tree() {
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    // 创建二叉树
    public void buildTree() {
        Scanner scn = null;
        try {
            scn = new Scanner(new File("/Users/x/icode/IdeaProjectsGit/Algorithm/src/main/resource/input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        root = createTree(root, scn);
    }

    // 先序遍历创建二叉树
    private TreeNode createTree(TreeNode root, Scanner scn) {
        String temp = scn.next();
        if (temp.trim().equals("#")) {
            return null;
        } else {
            root = new TreeNode(temp);
            root.setLeft(createTree(root.getLeft(), scn));
            root.setRight(createTree(root.getRight(), scn));
            return root;
        }
    }

    // 中序遍历（递归） —— 左、根、右
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.getLeft());
            System.out.print(root.getVal() + " ");
            inOrderTraverse(root.getRight());
        }
    }

    // 中序遍历（非递归）
    public void nrInorderTraverse() {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) { // 右子树不为空，或者栈不为空
            while (node != null) { // 从根或右子树开始，把所有的左孩子的左孩子全部入栈，直到找到最里面的左孩子
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop(); // 出栈左孩子或者根节点
            System.out.print(node.getVal() + " ");
            node = node.getRight(); // 遍历之后，处理右子树内容。循环遍历右子树的左孩子等等
        }
    }

    // 先序遍历（递归） —— 根、左、右
    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    public void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
            preOrderTraverse(root.getLeft());
            preOrderTraverse(root.getRight());
        }
    }

    // 先序遍历（非递归）
    public void nrPreOrderTraverse() {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) { // 右子树不为空，或者栈不为空
            while (node != null) {
                System.out.print(node.getVal() + " "); // 遍历根节点和左子树的一系列的“根”，并将它们全部入栈
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop(); // 弹出此时最里面的左子树根节点，判断其右子树情况
            node = node.getRight(); // 处理右子树情况
        }
    }

    // 后序遍历（递归） —— 左、右、根
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.getLeft());
            postOrderTraverse(root.getRight());
            System.out.print(root.getVal() + " ");
        }
    }

    // 后序遍历（非递归）
    public void nrPostOrderTraverse() {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode preNode = null; // 表示最近一次访问的节点
        while (node != null || !stack.isEmpty()) { // 右子树不为空，或者栈不为空（其子树已经处理过）
            while (node != null) { // 将根节点和左子树的根节点入栈，直到左子树为空
                stack.push(node);
                node = node.getLeft();
            }

            node = stack.peek(); // stack.peek()查找栈顶对象，但不移除它 查看栈顶元素
            if (node.getRight() == null || node.getRight() == preNode) { // 该节点的右子树为空，或者其右子树已经被访问过
                System.out.print(node.getVal() + " "); // 访问该节点
                node = stack.pop();
                preNode = node;
                node = null; // 将node置为空，用于判断栈中的下一元素
            } else {
                node = node.getRight();
            }
        }
    }

    // 按层次遍历
    public void levelTraverse() {
        levelTraverse(root);
    }

    public void levelTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>(); // Queue为接口
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll(); // queue.poll()获取并移除队头元素
            if (temp != null) {
                System.out.print(temp.getVal() + " ");
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                }
            }
        }
    }
}
