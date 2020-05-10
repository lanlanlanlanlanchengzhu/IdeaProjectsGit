package leetcode.no572;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author x
 * @date 2020-05-07
 */
public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        List<String> sPreRes = new ArrayList<>();
        preOrder(s, sPreRes);
        List<String> sMidRes = new ArrayList<>();
        midOrder(s, sMidRes);
        List<String> sPostRes = new ArrayList<>();
        postOrder(s, sPostRes);
        List<String> tPreRes = new ArrayList<>();
        preOrder(t, tPreRes);
        List<String> tMidRes = new ArrayList<>();
        midOrder(t, tMidRes);
        List<String> tPostRes = new ArrayList<>();
        postOrder(t, tPostRes);

        String sPreResStr =  sPreRes.stream().collect(Collectors.joining(""));
        String sMidResStr =  sMidRes.stream().collect(Collectors.joining(""));
        String sPostResStr =  sPostRes.stream().collect(Collectors.joining(""));
        String tPreResStr =  tPreRes.stream().collect(Collectors.joining(""));
        String tMidResStr =  tMidRes.stream().collect(Collectors.joining(""));
        String tPostResStr =  tPostRes.stream().collect(Collectors.joining(""));

        return sPreResStr.contains(tPreResStr) && sMidResStr.contains(tMidResStr) && sPostResStr.contains(tPostResStr);
    }

    /**
     * 先序遍历
     *
     * @param origin
     * @param result
     * @return
     */
    private List<String> preOrder(TreeNode origin, List<String> result) {
        if (origin == null) {
            result.add("null");
            return result;
        }
        result.add(new Integer(origin.val).toString());
        preOrder(origin.left, result);
        preOrder(origin.right, result);
        return result;
    }

    /**
     * 中序遍历
     *
     * @param origin
     * @param result
     * @return
     */
    private List<String> midOrder(TreeNode origin, List<String> result) {
        if (origin == null) {
            result.add("null");
            return result;
        }
        midOrder(origin.left, result);
        result.add(new Integer(origin.val).toString());
        midOrder(origin.right, result);
        return result;
    }

    /**
     * 后序遍历
     *
     * @param origin
     * @param result
     * @return
     */
    private List<String> postOrder(TreeNode origin, List<String> result) {
        if (origin == null) {
            result.add("null");
            return result;
        }
        postOrder(origin.left, result);
        postOrder(origin.right, result);
        result.add(new Integer(origin.val).toString());
        return result;
    }

}
