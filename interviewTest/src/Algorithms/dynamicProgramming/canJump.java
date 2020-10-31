package Algorithms.dynamicProgramming;

/*LeetCode 55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

        数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个位置。

        示例1:

        输入: [2,3,1,1,4]
        输出: true
        解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
        示例2:

        输入: [3,2,1,0,4]
        输出: false
        解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。*/

public class canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        /*if (n <= 1) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];*/

        int rightMost = 0;
        for (int i = 0; i < n; i++){
            if (i <= rightMost){
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1){
                    return true;
                }
            }
        }

        return false;
    }
}
