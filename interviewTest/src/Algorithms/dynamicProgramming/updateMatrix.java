package Algorithms.dynamicProgramming;

/*LeetCode 542. 01 矩阵
        给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

        两个相邻元素间的距离为 1 。

        示例 1：

        输入：
        [[0,0,0],
        [0,1,0],
        [0,0,0]]

        输出：
        [[0,0,0],
        [0,1,0],
        [0,0,0]]
        示例 2：

        输入：
        [[0,0,0],
        [0,1,0],
        [1,1,1]]

        输出：
        [[0,0,0],
        [0,1,0],
        [1,2,1]]


        提示：

        给定矩阵的元素个数不超过 10000。
        给定矩阵中至少有一个元素是 0。
        矩阵中的元素只在四个方向上相邻: 上、下、左、右。*/

public class updateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }

                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
            }
        }

        for (int i = r - 1; i >= 0; i--){
            for (int j = c - 1; j >= 0; j--) {
                    if (i < r - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j < c - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
            }
        }

        return dp;
    }
}
