package Algorithms;

/*LeetCode 645. 错误的集合
集合 S 包含从1到n的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

        给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

        示例 1:

        输入: nums = [1,2,2,4]
        输出: [2,3]
        注意:

        给定数组的长度范围是[2, 10000]。
        给定的数组是无序的。*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findErrorNums {

    public static int[] findErrorNums(int[] nums) {
        /*int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                res[0] = nums[i];
            }else{
                set.add(nums[i]);
            }
        }

        for(int j = 1; j <= nums.length; j++){
            if(!set.contains(j)){
                res[1] = j;
            }
        }

        return res;*/
        int dup = -1, miss = -1;
        for (int i = 1; i <= nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == i){
                    count++;
                }
            }
            if(count == 2){
                dup = i;
            }

            if(count == 0){
                miss = i;
            }
        }
        return new int[]{dup, miss};
    }
}
