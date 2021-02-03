package Algorithms.imooc;

/*51. N 皇后
        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



        示例 1：


        输入：n = 4
        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        解释：如上图所示，4 皇后问题存在两个不同的解法。
        示例 2：

        输入：n = 1
        输出：[["Q"]]


        提示：

        1 <= n <= 9
        皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class topic88 {
    private List<List<String>> res = new ArrayList<>();
    private boolean[] isCol;
    private boolean[] isDiaRightToLeft;
    private boolean[] isDiaLeftToRight;

    public List<List<String>> solveNQueens(int n) {

        List<Integer> rows = new ArrayList<>();
        isCol = new boolean[n];
        isDiaRightToLeft = new boolean[2 * n - 1];
        isDiaLeftToRight = new boolean[2 * n - 1];
        solveNQueensHelper(n, 0, rows);

        return res;
    }

    private void solveNQueensHelper(int n, int index, List<Integer> rows){
        if (index == n){
            res.add(generateBoard(n, rows));
            return;
        }

        for (int i = 0; i < n; i++){
            if (!isCol[i] && !isDiaRightToLeft[index + i] && !isDiaLeftToRight[index - i + n - 1]){
                rows.add(i);
                isCol[i] = true;
                isDiaLeftToRight[index + i] = true;
                isDiaRightToLeft[index - i + n - 1] = true;
                solveNQueensHelper(n, index + 1, rows);
                isCol[i] = false;
                isDiaLeftToRight[index + i] = false;
                isDiaRightToLeft[index - i + n - 1] = false;
                rows.remove(rows.size() - 1);
            }
        }

        return;
    }

    private List<String> generateBoard(int n, List<Integer> rows){
        List<String> need = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[rows.get(i)] = 'Q';
            need.add(new String(c));
        }

        return need;
    }
}
