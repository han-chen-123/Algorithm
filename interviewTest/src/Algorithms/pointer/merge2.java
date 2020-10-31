package Algorithms.pointer;

/*LeetCode 88. 合并两个有序数组
给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。

        说明:

        初始化nums1 和 nums2 的元素数量分别为m 和 n 。
        你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。

        示例:

        输入:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出:[1,2,2,3,5,6]*/


public class merge2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }

        while (m != 0){
            if (n > 0 && nums1[m - 1] < nums2[n - 1]){
                nums1[m + n - 1] = nums2[n - 1];
                n = n - 1;
            }else{
                nums1[m + n - 1] = nums1[m - 1];
                m = m - 1;
            }
        } 

        while (n != 0){
            nums1[m + n - 1] = nums2[n - 1];
            n = n - 1;
        }
    }
}
