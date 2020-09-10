package Algorithms;

/*LeetCode 73. 矩阵置零
给定一个m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

        示例1:

        输入:
        [
         [1,1,1],
         [1,0,1],
         [1,1,1]
        ]
        输出:
        [
         [1,0,1],
         [0,0,0],
         [1,0,1]
        ]
        示例2:

        输入:
        [
         [0,1,2,0],
         [3,4,5,2],
         [1,3,1,5]
        ]
        输出:
        [
        [0,0,0,0],
        [0,4,5,0],
        [0,3,1,0]
        ]
        进阶:

        一个直接的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
        一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
        你能想出一个常数空间的解决方案吗？*/


import java.util.HashSet;
import java.util.Set;

public class setZeroes {
    public void setZeroes(int[][] matrix) {
        //O(m + n)额外空间
        /*int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[row][col] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }

        }*/

        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        //第一行是否有0
        for(int j = 0; j < col; j++){
            if(matrix[0][j] == 0){
                row0 = true;
                break;
            }
        }

        //第一列是否有0
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                col0 = true;
                break;
            }
        }

        //把第一行第一列作为标志位
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
