package leetcode.no133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @see <href="https://leetcode-cn.com/problems/clone-graph/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china"></href="">
 *
 * 核心思想：图遍历算法
 * DFS：递归
 * BFS：借助队列
 */
public class Solution {

    /**
     * 图 克隆
     * DFS/HFS 本解法采用DFS
     * leetcode 运行失败，先忽略
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {

        // corner case
        if (node == null) {
            return null;
        }

        Map<Integer, Node> clonedNodes = new HashMap<>();
        return dfs(node, clonedNodes);

    }

    private Node dfs(Node node, Map<Integer, Node> clonedNodes) {

        // 递归出口 深度优先遍历过程中记录
        if (clonedNodes.containsKey(node.val)) {
            return clonedNodes.get(node.val);
        }

        // 先将当前记录放入已求值记录中
        Node clonedNode = new Node(node.val);
        clonedNodes.put(node.val, clonedNode);

        // 避免空指针
        if (node.neighbors != null) {
            List<Node> cloneNeighbors = new ArrayList<>();
            clonedNode.neighbors = cloneNeighbors;
            for (Node oneNode : node.neighbors) {
                cloneNeighbors.add(dfs(oneNode, clonedNodes));
            }
        }

        return clonedNode;

    }

    /**
     * BFS 深度优先遍历
     * leetcode 运行失败，先忽略
     *
     * @param node
     * @return
     */
    public Node cloneGraphBFS(Node node) {

        // corner case
        if (node == null) {
            return null;
        }

        // 记录已经遍历过的节点
        Map<Integer, Node> clonedNodes = new HashMap<>();
        Queue<Node> queue = new LinkedList();

        // 广度优先遍历开始
        Node clonedNode = new Node(node.val);
        clonedNodes.put(clonedNode.val, clonedNode);
        queue.offer(node);

        // 广度优先遍历——借助队列
        while (!queue.isEmpty()) {
            // 借助队列，广度优先遍历
            Node temp = queue.poll();
            // 避免空指针
            if (temp.neighbors != null) {
                for (Node oneNeighbor : temp.neighbors) {
                    if (!clonedNodes.containsKey(oneNeighbor.val)) {
                        Node oneCloned = new Node(oneNeighbor.val);
                        clonedNodes.put(oneCloned.val, oneCloned);
                        queue.offer(oneCloned);
                    }
                    // !!!依赖的节点先进性占位，后续具体填充依赖的节点
                    clonedNodes.get(temp.val).neighbors.add(clonedNodes.get(oneNeighbor.val));
                }
            }
        }

        return clonedNode;

    }

}
