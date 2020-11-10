package Algorithms.dynamicProgramming;

/*LeetCode 213. 打家劫舍 II
        你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



        示例 1：

        输入：nums = [2,3,2]
        输出：3
        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
        示例 2：

        输入：nums = [1,2,3,1]
        输出：4
        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        偷窃到的最高金额 = 1 + 3 = 4 。
        示例 3：

        输入：nums = [0]
        输出：0


        提示：

        1 <= nums.length <= 100
        0 <= nums[i] <= 1000*/

public class rob2 {
    public int rob2(int[] nums) {
        if(nums.length==0)  return 0;
        if(nums.length==1)  return nums[0];
        if(nums.length==2)  return Math.max(nums[0],nums[1]);
        int[] dp1=new int[nums.length-1];
        int[] dp2=new int[nums.length];
        //偷第一家和不偷第一家
        //1.可以偷第一家
        for(int i=0;i<nums.length-1;i++)
        {
            if(i<2)
            {
                dp1[0]=nums[0];
                dp1[1]=Math.max(dp1[0],nums[1]);
            }
            else
            {
                dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i]);
            }
        }
        //2.不偷第一家，可以偷最后一家
        for(int i=1;i<nums.length;i++)
        {
            if(i<3)
            {
                dp2[1]=nums[1];
                dp2[2]=Math.max(dp2[1],nums[2]);
            }
            else
            {
                dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
            }
        }
        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }
}
