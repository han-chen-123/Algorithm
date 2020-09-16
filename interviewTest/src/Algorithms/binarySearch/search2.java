package Algorithms.binarySearch;

/*
LeetCode 81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

        ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。

        编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。

        示例1:

        输入: nums = [2,5,6,0,0,1,2], target = 0
        输出: true
        示例2:

        输入: nums = [2,5,6,0,0,1,2], target = 3
        输出: false
        进阶:

        这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
        这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
*/

public class search2 {
    public boolean search(int[] nums, int target) {
        //二分法
        //因为数组排列情况不确定需要分情况讨论
        if (nums.length == 0 || nums == null) return false;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            //mid值等于target，找到了
            if (nums[mid] == target){
                return true;
            }

            //第一种无序情况 11101
            if (nums[start] == nums[mid]){
                start++;
                continue;
            }

            //第二种前半部分有序 2345671
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                //第三种后半部分有序 6712345
                if (nums[end] >= target && nums[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
