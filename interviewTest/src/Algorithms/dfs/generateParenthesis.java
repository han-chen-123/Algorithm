package Algorithms.dfs;

/*LeetCode 面试题 08.09. 括号*/
/*括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

        说明：解集不能包含重复的子集。

        例如，给出n = 3，生成结果为：

        [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]*/

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        dfs(0, 0, "", n, res);
        return res;
    }

    public void dfs(int left, int right, String str, int n, ArrayList<String> res){
        if(left == n && right == n){
            res.add(str);
            return;
        }
        if(right > left){
            return;
        }

        if(left < n) dfs(left + 1, right, str + "(", n, res);
        if(right < n) dfs(left, right + 1, str + ")", n, res);
    }
}
