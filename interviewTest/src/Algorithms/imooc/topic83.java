package Algorithms.imooc;

/*46. 全排列
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

import java.util.ArrayList;
import java.util.List;

public class topic83 {
    public List<List<Integer>> res = new ArrayList<>();
    public boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }

        used = new boolean[nums.length];
        List<Integer> finish = new ArrayList<>();
        permuteHelper(nums, 0, finish, used);
        return res;
    }

    public void permuteHelper(int[] nums, int index, List<Integer> finish, boolean[] used){
        if (index == nums.length){
            res.add(new ArrayList<>(finish));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            //什么时候把nums[i]加入finish中
            //当finsih中不含有nums[i]时
            if (!used[i]){
                used[i] = true;
                finish.add(nums[i]);
                permuteHelper(nums, index + 1, finish, used);
                used[i] = false;
                finish.remove(finish.size() - 1);
            }
        }
    }


    /*47. 全排列 II
    给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



    示例 1：

    输入：nums = [1,1,2]
    输出：
            [[1,1,2],
            [1,2,1],
            [2,1,1]]
    示例 2：

    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]*/

    public List<List<Integer>> permuteUnique(int[] nums) {

    }
}
