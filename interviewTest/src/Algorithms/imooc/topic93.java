package Algorithms.imooc;

/*343. 整数拆分
        给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

        示例 1:

        输入: 2
        输出: 1
        解释: 2 = 1 + 1, 1 × 1 = 1。
        示例 2:

        输入: 10
        输出: 36
        解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
        说明: 你可以假设 n 不小于 2 且不大于 58。*/

public class topic93 {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];
        return integerBreakHelper(n, memo);
    }

    public int integerBreakHelper(int n, int[] memo){
        if (n == 1){
            return 1;
        }

        if (memo[n] != 0){
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreakHelper(n - i, memo)));
        }

        memo[n] = res;
        return res;
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            //j和i - j
            for (int j = 1; j <= i - 1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

    /*279. 完全平方数
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

    给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



    示例 1：

    输入：n = 12
    输出：3
    解释：12 = 4 + 4 + 4
    示例 2：

    输入：n = 13
    输出：2
    解释：13 = 4 + 9*/

    public int numSquares(int n) {

    }


    /*91. 解码方法
    一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

            'A' -> 1
            'B' -> 2
            ...
            'Z' -> 26
    要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。

    给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。

    题目数据保证答案肯定是一个 32 位 的整数。



    示例 1：

    输入：s = "12"
    输出：2
    解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
    示例 2：

    输入：s = "226"
    输出：3
    解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
    示例 3：

    输入：s = "0"
    输出：0
    解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
    示例 4：

    输入：s = "06"
    输出：0
    解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。*/

    public int numDecodings(String s) {

    }


    /*62. 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

    问总共有多少条不同的路径？



    示例 1：


    输入：m = 3, n = 7
    输出：28
    示例 2：

    输入：m = 3, n = 2
    输出：3
    解释：
    从左上角开始，总共有 3 条路径可以到达右下角。
            1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
    示例 3：

    输入：m = 7, n = 3
    输出：28
    示例 4：

    输入：m = 3, n = 3
    输出：6*/

    public int uniquePaths(int m, int n) {

    }

    /*63. 不同路径 II
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



    网格中的障碍物和空位置分别用 1 和 0 来表示。



    示例 1：


    输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    输出：2
    解释：
            3x3 网格的正中间有一个障碍物。
    从左上角到右下角一共有 2 条不同的路径：
            1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
    示例 2：


    输入：obstacleGrid = [[0,1],[0,0]]
    输出：1


    提示：

    m == obstacleGrid.length
    n == obstacleGrid[i].length
1 <= m, n <= 100
    obstacleGrid[i][j] 为 0 或 1*/

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    }
}
