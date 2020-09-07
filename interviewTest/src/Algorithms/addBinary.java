package Algorithms;

/*LeetCode 67. 二进制求和

        给你两个二进制字符串，返回它们的和（用二进制表示）。

        输入为 非空 字符串且只包含数字1和0。

        示例1:

        输入: a = "11", b = "1"
        输出: "100"
        示例2:

        输入: a = "1010", b = "1011"
        输出: "10101"*/

public class addBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        // 定义 tag 记录二进制运算的进位。
        int tag = 0;
        // 从后往前遍历两个字符串并计算依次拼接每一位。
        for (int i = charsA.length - 1, j = charsB.length - 1; i >= 0 || j >= 0; i--, j--) {
            int curr = tag;
            // 只有两个字符串没有遍历完，就累加当前位置的数值。
            curr += i >= 0 ? charsA[i] - '0' : 0;
            curr += j >= 0 ? charsB[j] - '0' : 0;
            // 当前位置的和除以 2 ，余数就留在当前位置，商就表示进位。
            sb.append(curr % 2);
            tag = curr / 2;
        }
        // 两个字符串都遍历完以后判断最后是否还有进位。
        sb.append(tag == 1 ? tag : "");
        // 将最终结果翻转后返回。
        return sb.reverse().toString();
    }
}
