package Algorithms.imooc;

/*416. 分割等和子集
        给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

        注意:

        每个数组中的元素不会超过 100
        数组的大小不会超过 200
        示例 1:

        输入: [1, 5, 11, 5]

        输出: true

        解释: 数组可以分割成 [1, 5, 5] 和 [11].


        示例 2:

        输入: [1, 2, 3, 5]

        输出: false

        解释: 数组不能分割成两个元素和相等的子集.*/

import java.util.Arrays;

public class topic97 {
    //memo -1表示未计算， 0表示false， 1表示true
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if (sum % 2 == 1){
            return false;
        }

        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return canPartitionHelper(nums, nums.length - 1, sum / 2);
    }

    public boolean canPartitionHelper(int[] nums, int index, int sum){
        //[0 ... index]
        if (sum == 0){
            return true;
        }

        if (sum < 0 || index < 0){
            return false;
        }

        if (memo[index][sum] != -1){
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (canPartitionHelper(nums, index - 1, sum)
                || canPartitionHelper(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }
}
