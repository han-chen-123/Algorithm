package Algorithms.imooc;

/*70. 爬楼梯
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

        注意：给定 n 是一个正整数。

        示例 1：

        输入： 2
        输出： 2
        解释： 有两种方法可以爬到楼顶。
        1.  1 阶 + 1 阶
        2.  2 阶
        示例 2：

        输入： 3
        输出： 3
        解释： 有三种方法可以爬到楼顶。
        1.  1 阶 + 1 阶 + 1 阶
        2.  1 阶 + 2 阶
        3.  2 阶 + 1 阶*/

import java.util.Arrays;
import java.util.List;

public class topic92 {

    //自顶向下递归
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calways(n, memo);
    }

    private int calways(int n, int[] memo){
        if (n == 0 || n == 1){
            return 1;
        }

        if (memo[n] == -1){
            memo[n] = calways(n - 1, memo) + calways(n - 2, memo);
        }

        return memo[n];
    }

    //自底向上动态规划
    public int climbStairs2(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*120. 三角形最小路径和
    给定一个三角形 triangle ，找出自顶向下的最小路径和。

    每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



    示例 1：

    输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    输出：11
    解释：如下面简图所示：
            2
            3 4
            6 5 7
            4 1 8 3
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    示例 2：

    输入：triangle = [[-10]]
    输出：-10*/

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.size()];
        return minimumTotalHelper(triangle, 0, 0, memo);
    }

    private int minimumTotalHelper(List<List<Integer>> triangle, int x, int y, int[][] memo){
        if (x == triangle.size()){
            return 0;
        }

        if (memo[x][y] == 0){
            memo[x][y] = Math.min(minimumTotalHelper(triangle, x + 1, y, memo), minimumTotalHelper(triangle, x + 1, y + 1, memo))
                    + triangle.get(x).get(y);
        }

        return memo[x][y];
    }

    public int minimumTotal2(List<List<Integer>> triangle){
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    /*64. 最小路径和
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。



    示例 1：


    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小。
    示例 2：

    输入：grid = [[1,2,3],[4,5,6]]
    输出：12


    提示：

    m == grid.length
    n == grid[i].length
1 <= m, n <= 200
            0 <= grid[i][j] <= 100*/

    public int minPathSum(int[][] grid) {

    }
}
