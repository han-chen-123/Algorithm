package Algorithms;

/*LeetCode 59. 螺旋矩阵 II
给定一个正整数n，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3
        输出:
        [
        [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]
        ]*/


public class generateMatrix {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1, target = n * n;
        while(num <= target){
            for(int i = l; i <= r; i++) res[t][i] = num++;
            t++;
            for(int i = t; i <= b; i++) res[i][r] = num++;
            r--;
            for(int i = r; i >= l; i--) res[b][i] = num++;
            b--;
            for(int i = b; i >= t; i--) res[i][l] = num++;
            l++;

        }
        return res;
    }
}
