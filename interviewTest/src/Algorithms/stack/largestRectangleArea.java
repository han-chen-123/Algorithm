package Algorithms.stack;

/*
LeetCode 84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

        求在该柱状图中，能够勾勒出来的矩形的最大面积。


        以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。


        图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。

        示例:

        输入: [2,1,5,6,2,3]
        输出: 10
*/


import java.util.Stack;

public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        /*//暴力解法 固定高度 改变宽度 遍历所有矩形
        if (heights.length == 0) return 0;
        int res = 0;


        for (int i = 0; i < heights.length; i++){
            //延申左边到大于或者等于height【i】高度的宽
            int left = i;
            int currentHeight = heights[i];
            while (left > 0 && heights[left - 1] >= currentHeight){
                left--;
            }

            //右边
            int right = i;
            while (right < heights.length - 1 && heights[right + 1] >= currentHeight){
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * currentHeight);
        }

        return res;*/

        //单调栈
        int len = heights.length;
        if (len == 0) return 0;

        //左边小于的下标和右边小于的下标数组
        int[] left = new int[len];
        int[] right = new int[len];

        Stack<Integer> stack = new Stack<>();

        //从左往右遍历 找到左边小于栈顶的下标
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        //从右往左遍历
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            right[i] = (stack.isEmpty() ? len : stack.peek());
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < len; i++){
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
}
