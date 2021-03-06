package Algorithms.dfs;

/*LeetCode 40. 组合总和 II*/
/*给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

        candidates中的每个数字在每个组合中只能使用一次。

        说明：

        所有数字（包括目标数）都是正整数。
        解集不能包含重复的组合。
        示例1:

        输入: candidates =[10,1,2,7,6,1,5], target =8,
        所求解集为:
        [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
        ]
        示例2:

        输入: candidates =[2,5,2,1,2], target =5,
        所求解集为:
        [
         [1,2,2],
         [5]
        ]*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2 {

    public List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, track);
        return res;
    }

    public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> track){
        if (target < 0) return;
        
        if (target == 0){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++){
            if (target < candidates[i]){
                continue;
            }
            
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, track);
            track.removeLast();
        }
    }
}
