package Algorithms.dfs;

/*LeetCode 576. 出界的路径数
给定一个 m × n 的网格和一个球。球的起始坐标为(i,j)，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109+ 7 的值。
        示例 1：

        输入: m = 2, n = 2, N = 2, i = 0, j = 0
        输出: 6
        解释:

        示例 2：

        输入: m = 1, n = 3, N = 3, i = 0, j = 1
        输出: 12
        解释:

        说明:

        球一旦出界，就不能再被移动回网格内。
        网格的长度和高度在 [1,50] 的范围内。
        N 在 [0,50] 的范围内。*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class findPaths {
    int mod = (int) 1e9 + 7;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m, n, N, i, j, new Integer[m][n][N + 1]);
    }

    public int dfs(int m, int n, int N, int i, int j, Integer memo[][][]){
        int count = 0;
        if(i < 0 || j < 0 || i >= m || j >= n){
            return 1;
        }

        if(N == 0){
            return 0;
        }

        if(memo[i][j][N] != null){
            return memo[i][j][N];
        }

        for (int k = 0; k < 4; k++){
            count += dfs(m, n, N - 1, i - dir[k][0], j - dir[k][1], memo);
            count %= mod;
        }

        return memo[i][j][N] = count;
    }
}
