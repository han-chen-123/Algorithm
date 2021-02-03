package Algorithms.imooc;

/*77. 组合
        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

        示例:

        输入: n = 4, k = 2
        输出:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/

import java.util.ArrayList;
import java.util.List;

public class topic84 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n){
            return res;
        }

        List<Integer> finish = new ArrayList<>();
        combineHelper(n, k, 1, finish);
        return res;
    }

    public void combineHelper(int n, int k, int start, List<Integer> finish){
        if (finish.size() == k){
            res.add(new ArrayList<>(finish));
            return;
        }

        for (int i = start; i <= n - (k - finish.size()) + 1; i++){
            finish.add(i);
            combineHelper(n, k, i + 1, finish);
            finish.remove(finish.size() - 1);
        }
    }


    /*39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的数字可以无限制重复被选取。

    说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。
    示例 1：

    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
            [
            [7],
            [2,2,3]
            ]
    示例 2：

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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    }

    /*40. 组合总和 II
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的每个数字在每个组合中只能使用一次。

    说明：

    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。
    示例 1:

    输入: candidates = [10,1,2,7,6,1,5], target = 8,
    所求解集为:
            [
            [1, 7],
            [1, 2, 5],
            [2, 6],
            [1, 1, 6]
            ]
    示例 2:

    输入: candidates = [2,5,2,1,2], target = 5,
    所求解集为:
            [
            [1,2,2],
            [5]
            ]*/

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    }

    /*216. 组合总和 III
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

    说明：

    所有数字都是正整数。
    解集不能包含重复的组合。
    示例 1:

    输入: k = 3, n = 7
    输出: [[1,2,4]]
    示例 2:

    输入: k = 3, n = 9
    输出: [[1,2,6], [1,3,5], [2,3,4]]*/

    public List<List<Integer>> combinationSum3(int k, int n) {

    }

    /*78. 子集
    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



    示例 1：

    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：

    输入：nums = [0]
    输出：[[],[0]]


    提示：

            1 <= nums.length <= 10
            -10 <= nums[i] <= 10
    nums 中的所有元素 互不相同*/

    public List<List<Integer>> subsets(int[] nums) {

    }

    /*90. 子集 II
    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    说明：解集不能包含重复的子集。

    示例:

    输入: [1,2,2]
    输出:
            [
            [2],
            [1],
            [1,2,2],
            [2,2],
            [1,2],
            []
            ]*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {

    }
}
