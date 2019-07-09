package leetcode.no22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    class InnerNode {
        String str;
        int resKuohao;
        int currKuohao;

        public InnerNode() {
        }

        public InnerNode(String str, int resKuohao, int currKuohao) {
            this.str = str;
            this.resKuohao = resKuohao;
            this.currKuohao = currKuohao;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();

        if (n <= 0) {
            return res;
        }

        Queue<InnerNode> queue = new LinkedList();

        ((LinkedList) queue).add(new InnerNode("(", n-1, 1));

        InnerNode innerNode = new InnerNode();

        while (!queue.isEmpty()) {
            // 每次取队列第一个
            innerNode = queue.poll();

            if (innerNode.resKuohao == 0) {
                // 符合结束条件
                res.add(appendMiss(innerNode.str, innerNode.currKuohao));
            } else {
                // 继续递归  两种情况：1.只能补(;2.可以补(或)
                // 补齐(
                ((LinkedList<InnerNode>) queue).add(
                        new InnerNode(innerNode.str + "(", innerNode.resKuohao - 1, innerNode.currKuohao + 1));

                if (innerNode.currKuohao > 0) {
                    // 补齐)
                    ((LinkedList<InnerNode>) queue).add(
                            new InnerNode(innerNode.str + ")", innerNode.resKuohao, innerNode.currKuohao - 1));
                }

            }

        }

        return res;
    }

    public String appendMiss (String org, int count) {
        for (int i = 0; i < count; i++) {
            org += ")";
        }
        return org;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

}
