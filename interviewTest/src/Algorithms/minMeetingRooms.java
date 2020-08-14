package Algorithms;

/*LeetCode 253 会议室 II
给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

        示例 1:

        输入: [[0, 30],[5, 10],[15, 20]]
        输出: 2
        示例 2:

        输入: [[7,10],[2,4]]
        输出: 1*/

import java.util.Arrays;

public class minMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startGroup = new int[n];
        int[] endGroup = new int[n];

        for(int i = 0; i < n; i++){
            startGroup[i] = intervals[i][0];
            endGroup[i] = intervals[i][1];
        }

        Arrays.sort(startGroup);
        Arrays.sort(endGroup);

        int count = 0;
        int startPos = 0, endPos = 0;

        while(startPos < startGroup.length && endPos < endGroup.length){
            if(startGroup[startPos] < endGroup[endPos]){
                count++;
            }else{
                endPos++;
            }
            startPos++;
        }

        return count;
    }
}
