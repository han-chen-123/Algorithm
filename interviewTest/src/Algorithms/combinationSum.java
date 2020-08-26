package Algorithms;

/*LeetCode 39. 组合总和*/
/*给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

        candidates中的数字可以无限制重复被选取。

        说明：

        所有数字（包括target）都是正整数。
        解集不能包含重复的组合。
        示例1：

        输入：candidates = [2,3,6,7], target = 7,
        所求解集为：
        [
        [7],
        [2,2,3]
        ]
        示例2：

        输入：candidates = [2,3,5], target = 8,
        所求解集为：
        [
        [2,2,2,2],
        [2,3,3],
        [3,5]
        ]

        提示：

        1 <= candidates.length <= 30
        1 <= candidates[i] <= 200
        candidate 中的每个元素都是独一无二的。
        1 <= target <= 500*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum {

    public static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, track);
        return res;
    }

    public static void backtrack(int[] candidates, int start, int target, LinkedList<Integer> track){
        if (target < 0) return;

        if (target == 0){
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            track.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5},8);
        System.out.println(res);
    }
}
