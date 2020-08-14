package Algorithms;

/*LeetCode 1464. 数组中两元素的最大乘积*/
/*给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

        请你计算并返回该式的最大值。

        示例 1：

        输入：nums = [3,4,5,2]
        输出：12
        解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
        示例 2：

        输入：nums = [1,5,4,5]
        输出：16
        解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
        示例 3：

        输入：nums = [3,7]
        输出：12*/

import java.util.Arrays;

public class maxProduct {
    public int maxProduct(int[] nums) {
        //int res = 0;
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);

        //暴力解法，两次循环
        /*int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n; i++){
            for(int j = i; j < n; j++){
                if(i != j){
                    res = Math.max(res, (nums[i] - 1)*(nums[j] - 1));
                }
            }
        }
        return res;*/
    }
}
