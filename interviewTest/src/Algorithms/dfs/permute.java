package Algorithms.dfs;

/*LeetCode 46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        示例:

        输入: [1,2,3]
        输出:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]*/


import java.util.LinkedList;
import java.util.List;

public class permute {

    public static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track){
        if(nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
    }
}
