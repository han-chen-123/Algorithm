package Algorithms.greedy;

/*LeetCode 435. 无重叠区间
        给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

        注意:

        可以认为区间的终点总是大于它的起点。
        区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
        示例 1:

        输入: [ [1,2], [2,3], [3,4], [1,3] ]

        输出: 1

        解释: 移除 [1,3] 后，剩下的区间没有重叠。
        示例 2:

        输入: [ [1,2], [1,2], [1,2] ]

        输出: 2

        解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
        示例 3:

        输入: [ [1,2], [2,3] ]

        输出: 0

        解释: 你不需要移除任何区间，因为它们已经是无重叠的了。*/

        /*在选择要保留区间时，区间的结尾十分重要：选择的区间结尾越小，余留给其它区间的空间
        就越大，就越能保留更多的区间。因此，我们采取的贪心策略为，优先保留结尾小且不相交的区
        间。
        具体实现方法为，先把区间按照结尾的大小进行增序排序，每次选择结尾最小且和前一个选
        择的区间不重叠的区间。我们这里使用 C++ 的 Lambda，结合 std::sort() 函数进行自定义排
        序。
        在样例中，排序后的数组为 [[1,2], [1,3], [2,4]]。按照我们的贪心策略，首先初始化为区间
        [1,2]；由于 [1,3] 与 [1,2] 相交，我们跳过该区间；由于 [2,4] 与 [1,2] 不相交，我们将其保留。因
        此最终保留的区间为 [[1,2], [2,4]]。*/

import java.util.Arrays;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] > b[1] ? 1 : -1);

        int x_end = intervals[0][1], count = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < x_end) count++;
            else x_end = intervals[i][1];
        }

        return count;
    }
}
