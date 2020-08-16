package Algorithms;

/*LeetCode 41. 缺失的第一个正数
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

        示例1:

        输入: [1,2,0]
        输出: 3
        示例2:

        输入: [3,4,-1,1]
        输出: 2
        示例3:

        输入: [7,8,9,11,12]
        输出: 1

        提示：

        你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。*/

public class firstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 1; i <= nums.length; i++){
            boolean has = false;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == i){
                    has = true;
                    break;
                }
            }

            if(!has){
                return i;
            }
        }
        return nums.length + 1;
    }
}
