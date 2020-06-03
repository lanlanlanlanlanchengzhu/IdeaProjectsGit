package leetcode.no695;

/**
 * @author x
 * @date 2020-05-18
 */
public class Solution {

    int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, getMax(grid, i, j));
            }
        }
        return res;
    }
    private int getMax(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == 0) {
            return 0;
        } else {
            grid[row][col] = 0;
            int res = 1;
            for (int i = 0; i < directions.length; i++) {
                res += getMax(grid, row + directions[i][0] , col + directions[i][1]);
            }
            return res;
        }
    }

}
