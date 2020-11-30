package Algorithms.dfs;

/*LeetCode 51. N 皇后
        n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



        上图为 8 皇后问题的一种解法。

        给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

        每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



        示例：

        输入：4
        输出：[
        [".Q..",  // 解法 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // 解法 2
        "Q...",
        "...Q",
        ".Q.."]
        ]
        解释: 4 皇后问题存在两个不同的解法。


        提示：

        皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solveNQueens {
    int N;
    char[][] board;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (char[] line : board){
            Arrays.fill(line, '.');
        }
        backtrack(0);
        return res;
    }

    public void backtrack(int r){
        if (r == N){
            List<String> path = new ArrayList<>();
            for (char[] line : board){
                path.add(String.valueOf(line));
            }
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < N; j++){
            if (isValid(r, j)){
                board[r][j] = 'Q';
                backtrack(r + 1);
                board[r][j] = '.';
            }
        }
    }

    public boolean isValid(int x, int y){
        for (int i = 0; i < x; i++){
            if (board[i][y] == 'Q'){
                return false;
            }
        }

        for (int j = 0; j < y; j++){
            if (board[x][j] == 'Q'){
                return false;
            }
        }

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
