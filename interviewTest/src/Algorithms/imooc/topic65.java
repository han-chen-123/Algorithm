package Algorithms.imooc;

/*279. 完全平方数
        给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

        给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

        完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



        示例 1：

        输入：n = 12
        输出：3
        解释：12 = 4 + 4 + 4
        示例 2：

        输入：n = 13
        输出：2
        解释：13 = 4 + 9

        提示：

        1 <= n <= 104*/

import com.sun.org.apache.xerces.internal.xs.XSTerm;
import javafx.util.Pair;

import java.util.LinkedList;

public class topic65 {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0){
                return step;
            }

            for (int i = 1; num - i * i >= 0; i++ ){
                if (!visited[num - i * i]){
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        return 0;
    }

}
