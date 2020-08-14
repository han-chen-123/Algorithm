package Algorithms.dfs;

/*LeetCode 130. 被围绕的区域*/
/*
给定一个二维的矩阵，包含'X'和'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。

        示例:

        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：

        X X X X
        X X X X
        X X X X
        X O X X
        解释:

        被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/

public class solve {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(row == 0 || col == 0 || board == null || board[0] == null){
            return;
        }
        for(int i = 0; i < row; i++){
            //第一列
            if(board[i][0] == 'O'){
                dfs(i, 0, board, row, col);
            }
            //最后一列
            if(board[i][col - 1] == 'O'){
                dfs(i, col - 1, board, row, col);
            }
        }

        for(int j = 0; j < col; j++){
            //第一行
            if(board[0][j] == 'O'){
                dfs(0, j, board, row, col);
            }
            //最后一行
            if(board[row - 1][j] == 'O'){
                dfs(row - 1, j, board, row, col);
            }
        }
        //遍历整个矩阵，把o变x，k变o；
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'K'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board, int row, int col){
        board[i][j] = 'K';
        for(int[] dir : dirs){
            int temp_i = i + dir[0];
            int temp_j = j + dir[1];
            if(temp_i < 0 || temp_i >= row || temp_j < 0 || temp_j >= col || board[temp_i][temp_j] != 'O'){
                continue;
            }
            dfs(temp_i, temp_j, board, row, col);
        }
    }
}
