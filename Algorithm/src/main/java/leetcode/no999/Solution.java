package leetcode.no999;

/**
 * @author x
 * @date 2020-04-05
 * @see <href="https://leetcode-cn.com/problems/available-captures-for-rook/"/>
 *
 * 棋盘问题中，方向数组可以解决重复代码，四个方向，分别为二维数组的四个元素
 */
public class Solution {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：额外O(1)
     *
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        int cheRow = -1;
        int cheCol = -1;

        // 找到车位置
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'R') {
                    cheRow = i;
                    cheCol = j;
                    break;
                }
            }
        }

        int res = 0;

        if (cheCol >= 0 && cheRow >= 0) {
            for (int i = cheRow + 1; i < row; i++) {
                if (board[i][cheCol] == 'p') {
                    res++;
                    break;
                }
                if (board[i][cheCol] == 'B') {
                    break;
                }
            }
            for (int i = cheRow - 1; i >= 0; i--) {
                if (board[i][cheCol] == 'p') {
                    res++;
                    break;
                }
                if (board[i][cheCol] == 'B') {
                    break;
                }
            }
            for (int i = cheCol + 1; i < row; i++) {
                if (board[cheRow][i] == 'p') {
                    res++;
                    break;
                }
                if (board[cheRow][i] == 'B') {
                    break;
                }
            }
            for (int i = cheCol - 1; i >= 0; i--) {
                if (board[cheRow][i] == 'p') {
                    res++;
                    break;
                }
                if (board[cheRow][i] == 'B') {
                    break;
                }
            }
        }

        return res;
    }

}
