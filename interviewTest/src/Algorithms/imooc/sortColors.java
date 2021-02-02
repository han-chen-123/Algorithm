package Algorithms.imooc;

/*75. 颜色分类
        给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。



        示例 1：

        输入：nums = [2,0,2,1,1,0]
        输出：[0,0,1,1,2,2]
        示例 2：

        输入：nums = [2,0,1]
        输出：[0,1,2]
        示例 3：

        输入：nums = [0]
        输出：[0]
        示例 4：

        输入：nums = [1]
        输出：[1]*/

import java.util.ArrayList;

public class sortColors {
    public void sortColors(int[] nums) {
        //计数排序
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++){
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++){
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++){
            nums[index++] = 2;
        }
    }

    public void sortColors2(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < nums.length;){
            if (nums[i] == 1){
                i++;
            }else if (nums[i] == 2){
                two--;
                swap(nums, i, two);
            }else {
                zero++;
                swap(nums, i, zero);
                i++;
            }
        }

    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //88
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0){
            if (nums1[i] < nums2[j]){
                nums1[k] = nums2[j];
                k--;
                j--;
            }else {
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    //215

}
