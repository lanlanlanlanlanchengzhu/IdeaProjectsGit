package leetcode.bintree;


public class BinaryTreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.buildTree();
        System.out.println("中序遍历");
        tree.inOrderTraverse();
        System.out.println("\n中序遍历（非递归）");
        tree.nrInorderTraverse();
        System.out.println("\n先序遍历");
        tree.preOrderTraverse();
        System.out.println("\n先序遍历（非递归）");
        tree.nrPreOrderTraverse();
        System.out.println("\n后序遍历");
        tree.postOrderTraverse();
        System.out.println("\n后序遍历（非递归）");
        tree.nrPostOrderTraverse();
        System.out.println("\n层次遍历");
        tree.levelTraverse();
    }
}
