package Algorithms;

/*LeetCode 349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

        示例 1：

        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]
        示例 2：

        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]


        说明：

        输出结果中的每个元素一定是唯一的。
        我们可以不考虑输出结果的顺序。*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> parent = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for (int num : nums1){
            parent.add(num);
        }

        for (int num : nums2){
            if (parent.contains(num)){
                children.add(num);
            }
        }

        int[] res = new int[children.size()];
        int index = 0;
        for (int value : children){
            res[index++] = value;
        }

        return res;
    }
}
