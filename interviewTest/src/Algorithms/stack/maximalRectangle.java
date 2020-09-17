package Algorithms.stack;

/*LeetCode 85. 最大矩形
给定一个仅包含0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

        示例:

        输入:
        [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
        ]
        输出: 6*/


import java.util.Stack;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;
        //需要设置两个哨兵
        int[] height = new int[col + 2];
        int res = 0;

        for (int i = 0; i < row; i++){
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < col + 2; j++){
                //确保范围不超过两个哨兵的值
                if (j >= 1 && j <= col){
                    if (matrix[i][j - 1] == '1'){
                        height[j] += 1;
                    }else {
                        height[j] = 0;
                    }
                }

                while (!stack.isEmpty() && height[stack.peek()] > height[j]){
                    int cur = stack.pop();
                    res = Math.max(res, (j - stack.peek() - 1) * height[cur]);
                }

                stack.push(j);
            }
        }

        return res;
    }
}
