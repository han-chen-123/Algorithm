package Algorithms;

/*560. 和为K的子数组
        给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

        示例 1 :

        输入:nums = [1,1,1], k = 2
        输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
        说明 :

        数组的长度为 [1, 20,000]。
        数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。*/

public class subarraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];

        preSum[0] = 0;
        for (int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        //穷举所有子树组
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if (preSum[i] - preSum[j] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
