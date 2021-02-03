package Algorithms.imooc;

/*200. 岛屿数量
        给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

        此外，你可以假设该网格的四条边均被水包围。



        示例 1：

        输入：grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        输出：1
        示例 2：

        输入：grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
        输出：3*/

import java.util.List;

public class topic87 {
    private boolean[][] visited;
    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {

        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if (newX < grid.length && newY < grid[0].length && newX >= 0 && newY >= 0
                    && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(grid, newX, newY, visited);
            }
        }

        return;
    }

    /*130. 被围绕的区域
    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

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

    被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
}*/

    public void solve(char[][] board) {

    }

    /*417. 太平洋大西洋水流问题
    给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。

    规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。

    请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。



    提示：

    输出坐标的顺序不重要
    m 和 n 都小于150


    示例：



    给定下面的 5x5 矩阵:

    太平洋 ~   ~   ~   ~   ~
            ~  1   2   2   3  (5) *
            ~  3   2   3  (4) (4) *
            ~  2   4  (5)  3   1  *
            ~ (6) (7)  1   4   5  *
            ~ (5)  1   1   2   4  *
            *   *   *   *   * 大西洋

    返回:

            [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).*/

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

    }
}
