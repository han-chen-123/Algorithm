package Algorithms.binarySearch;

/*LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

        你的算法时间复杂度必须是O(log n) 级别。

        如果数组中不存在目标值，返回[-1, -1]。

        示例 1:

        输入: nums = [5,7,7,8,8,10], target = 8
        输出: [3,4]
        示例2:

        输入: nums = [5,7,7,8,8,10], target = 6
        输出: [-1,-1]*/

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                left = mid;
                right = mid;

                while(left - 1 >= 0 && nums[left - 1] == target){
                    left--;
                }

                while(right + 1 < nums.length && nums[right + 1] == target){
                    right++;
                }

                return new int[]{left, right};
            }
        }

        return new int[]{-1, -1};
    }
}
