package Algorithms.imooc;

/*283. 移动零
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        示例:

        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
        说明:

        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。*/

import java.util.ArrayList;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> nonZeroElements = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nonZeroElements.add(nums[i]);
            }
        }

        for (int i = 0; i < nonZeroElements.size(); i++){
            nums[i] = nonZeroElements.get(i);
        }

        for (int i = nonZeroElements.size(); i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public void moveZero2(int[] nums){
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length + 1; i++){
            nums[i] = 0;
        }
    }

    public void moveZero3(int[] nums){
        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                swap(nums, k++, i);
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }




    //27
    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                arr.add(nums[i]);
            }
        }

        int[] res = new int[arr.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = arr.get(i);
        }

        return res.length;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }
}


