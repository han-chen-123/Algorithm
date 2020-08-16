package Algorithms;

/*LeetCode 56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

        示例 1:

        输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        示例2:

        输入: intervals = [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。*/


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right){
                i++;
                right = Math.max(right, intervals[i][1]);
            }

            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
