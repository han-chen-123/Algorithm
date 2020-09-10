package Algorithms.binarySearch;

/*LeetCode 74. 搜索二维矩阵
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。
        示例1:

        输入:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        输出: true
        示例2:

        输入:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 13
        输出: false*/

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //二分查找
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right){
            //中间的序号
            int mid = left + (right - left) / 2;
            //在矩阵中获取中间序号的数值
            int matrixMid = matrix[mid / col][mid % col];
            if(matrixMid == target){
                return true;
            }else {
                //缩小右边窗口
                if (target < matrixMid){
                    right = mid - 1;
                    //缩小左边窗口
                }else if(target > matrixMid){
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}
