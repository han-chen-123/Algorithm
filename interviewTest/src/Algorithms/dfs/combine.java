package Algorithms.dfs;
import java.util.*;

/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

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

public class combine {

    List<List<Integer>> result = new LinkedList<>();
    int k;
    int n;

    public void backtrack(int first, LinkedList<Integer> current){
        if (current.size() == k) result.add(new LinkedList(current));

        for (int i = first; i < n + 1; ++i){
            current.add(i);
            backtrack(i + 1, current);
            current.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());

        return result;
    }

    public static void main(String[] args) {
        combine test = new combine();
        System.out.println(test.combine(4,2));
    }
}
