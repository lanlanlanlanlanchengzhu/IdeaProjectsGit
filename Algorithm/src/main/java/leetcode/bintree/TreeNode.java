package leetcode.bintree;


// 树的节点
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String val;

    public TreeNode(){

    }
    public TreeNode(String val) {
        super();
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right, String val) {
        super();
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
}

