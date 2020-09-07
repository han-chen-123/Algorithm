package Algorithms;

/*LeetCode 66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例1:

        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。
        示例2:

        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。*/


public class plusOne {
    public int[] plusOne(int[] digits) {
        //关键是末尾是9 进一的处理
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0) return digits;
        }

        //遍历到头都是0,数组需要扩充一位
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
