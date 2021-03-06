package Algorithms;

/*LeetCode 54. 螺旋矩阵
给定一个包含m x n个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

        示例1:

        输入:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        输出: [1,2,3,6,9,8,7,4,5]
        示例2:

        输入:
        [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
        ]
        输出: [1,2,3,4,8,12,11,10,9,5,6,7]*/

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++){
            res.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + direction[directionIndex][0], nextColumn = column + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }
        return res;
    }
}
