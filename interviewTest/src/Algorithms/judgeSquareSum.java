package Algorithms;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

        示例1:

        输入: 5
        输出: True
        解释: 1 * 1 + 2 * 2 = 5
         

        示例2:

        输入: 3
        输出: False*/


public class judgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int sqrC = (int)Math.sqrt(c);
        int right = sqrC;
        int sum = 0;

        while (left <= sqrC && left >= 0){
            sum = left * left + right * right;
            if (sum == c) {
                return true;
            }else if (sum < c) {
                left++;
            }else if (sum > c) {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        judgeSquareSum test = new judgeSquareSum();
        System.out.println(test.judgeSquareSum(3));
    }
}
