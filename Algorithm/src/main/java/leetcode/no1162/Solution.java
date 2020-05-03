package leetcode.no1162;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author x
 * @date 2020-04-06
 */
public class Solution {

    /**
     * BFS——广度优先搜索
     * 只要有一个节点是陆地，则结束，此陆地为最近陆地
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = getMinDistance(grid, i, j);
                if (temp > res) {
                    res = temp;
                }
            }
        }
        return res;
    }
    
    private int getMinDistance (int[][] grid, int row, int col) {

        // !!!方向数组，棋盘问题标准解决方案，遍历即可访问四个方向
        int [][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        // !!!记录已经访问过的节点
        int[][] count = new int[grid.length][grid[0].length];

        // 初始节点节点入队
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        if (grid[row][col] == 0) {
            // 海洋，入队
            queue.add(new Pair<>(row, col));
            // !!!记录已经访问过的节点
            count[row][col] = 1;
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            for (int i = 0; i < direction.length; i++) {
                int[] oneDirection = direction[i];
                int nextRow = curr.getKey() + oneDirection[0];
                int nextCol = curr.getValue() + oneDirection[1];
                if (0 <= nextRow && nextRow < grid.length &&
                        0 <= nextCol && nextCol < grid[0].length) {
                    // 数组未越界
                    if (grid[nextRow][nextCol] == 1) {
                        // 陆地，直接结束
                        return Math.abs(nextRow - row) + Math.abs(nextCol - col);
                    } else {
                        Pair temp = new Pair<>(nextRow, nextCol);
                        if (count[nextRow][nextCol] != 1) {
                            // BFS必备计数set，防止死循环
                            // 海洋，入队，继续搜索
                            ((LinkedList<Pair<Integer,Integer>>) queue).add(temp);
                            // !!!记录已经访问过的节点
                            count[nextRow][nextCol] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
