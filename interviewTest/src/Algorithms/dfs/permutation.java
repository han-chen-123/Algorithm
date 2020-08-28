package Algorithms.dfs;

/*Leetcode 面试题 08.07. 无重复字符串的排列组合*/
/*无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

        示例1:

        输入：S = "qwe"
        输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
        示例2:

        输入：S = "ab"
        输出：["ab", "ba"]*/


import java.util.ArrayList;
import java.util.List;

public class permutation {

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(res, S, new StringBuilder(), new boolean[S.length()]);
        return res.toArray(new String[res.size()]);
    }

    public void backtrack(List<String> res, String S, StringBuilder sb, boolean[] marked){
        if(sb.length() == S.length()){
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i < S.length(); i++){
            if(!marked[i]){
                marked[i] = true;
                sb.append(S.charAt(i));
                backtrack(res, S, sb, marked);
                sb.deleteCharAt(sb.length() - 1);
                marked[i] = false;
            }
        }
    }

/*LeetCode 78. 子集*/
    
    public List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    public void backtrack2(List<List<Integer>> res, ArrayList<Integer> tmp, int i, int[] nums){
        res.add(new ArrayList<>(tmp));
        for(int j = i; j < nums.length; j++){
            tmp.add(nums[j]);
            backtrack2(res, tmp, j + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
