package leetcode.no1391;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author x
 * @date 2020-04-01
 *
 * @see <href="https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/"/>
 */
public class Solution {

    /**
     * 解题思路 BFS 从第一个节点出发，向四个方向探测
     * 重点：搞清楚二维数组坐标与方向的关系！
     *
     * @param grid
     * @return
     */
    public boolean hasValidPath(int[][] grid) {
        // 记录访问过的节点
        Set<Pair<Integer, Integer>> count = new HashSet<>();
        // BFS辅助队列
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        // 先将首节点入队
        queue.offer(new Pair<>(0, 0));

        // 上下左右
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 开始BFS
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int xIndexMax = grid.length - 1;
            int yIndexMax = grid[0].length - 1;
            // 递归出口-右下角节点
            if (curr.getKey() == xIndexMax && curr.getValue() == yIndexMax) {
                return true;
            }
            // 判断当前节点上下左右四个节点是否可以连通
            int currx = curr.getKey();
            int curry = curr.getValue();
            for (int i = 0; i < dx.length; i++) {
                int nextx = currx + dx[i];
                int nexty = curry + dy[i];
                if (nextx > xIndexMax || nextx < 0 || nexty > yIndexMax || nexty < 0) {
                    //  数组下标越界，不存在，直接跳过
                    continue;
                }
                Pair<Integer, Integer> nextPair = new Pair<>(nextx, nexty);
                if (canTouch(grid[currx][curry], grid[nextx][nexty], i) && !count.contains(nextPair)) {
                    // 可以连通，放入队列中
                    // 记录已经遍历过的点
                    count.add(nextPair);
                    queue.offer(nextPair);
                }

            }
        }

        return false;
    }

    /**
     * 判断当前节点和下一节点向指定方向是否可联通
     *
     * @param curr
     * @param next
     * @param direction 0上 1下 2左 3右
     *
     * @return
     */
    private boolean canTouch (int curr, int next, int direction) {
        if (direction == 0) {
            if ((curr == 2 || curr == 5 || curr == 6) && (next == 2 || next == 3 || next == 4)) {
                return true;
            }
        }
        if (direction == 1) {
            if ((curr == 2 || curr == 3 || curr == 4) && (next == 2 || next == 5 || next == 6)) {
                return true;
            }
        }
        if (direction == 2) {
            if ((curr == 1 || curr == 3 || curr == 5) && (next == 1 || next == 4 || next == 6)) {
                return true;
            }
        }
        if (direction == 3) {
            if ((curr == 1 || curr == 4 || curr == 6) && (next == 1 || next == 3 || next == 5)) {
                return true;
            }
        }
        return false;
    }

}
