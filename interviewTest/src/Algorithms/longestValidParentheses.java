package Algorithms;

/*LeetCode 32. 最长有效括号
给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。

        示例1:

        输入: "(()"
        输出: 2
        解释: 最长有效括号子串为 "()"
        示例 2:

        输入: ")()())"
        输出: 4
        解释: 最长有效括号子串为 "()()"*/


import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
