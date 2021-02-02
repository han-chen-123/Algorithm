package Algorithms.divideAndConquer;

/*LeetCode 312. 戳气球
        有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

        现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

        求所能获得硬币的最大数量。

        说明:

        你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
        0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
        示例:

        输入: [3,1,5,8]
        输出: 167
        解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
        coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167*/

public class maxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        //len为开区间长度
        for (int len = 3; len <= n + 2; len++){
            //左边
            for (int i = 0; i <= n + 2 - len; i++){
                int res = 0;
                for (int j = i + 1; j < i + len - 1; j++){
                    res = Math.max(res, dp[i][j] + newNums[i] * newNums[j]*newNums[i + len - 1] +dp[j][i + len - 1]);
                }
                dp[i][i + len - 1] = res;
            }
        }

        return dp[0][n + 1];
    }
}
