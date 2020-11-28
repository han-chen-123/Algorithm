package Algorithms.pointer;

/*LeetCode 680. 验证回文字符串 Ⅱ
        给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

        示例 1:

        输入: "aba"
        输出: True
        示例 2:

        输入: "abca"
        输出: True
        解释: 你可以删除c字符。*/

public class validPalindrome {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) return true;

        int left = 0, right = s.length() - 1;
        while(left < right) {
            char c1 = s.charAt(left), c2 = s.charAt(right);
            if (c1 == c2) {
                left++;
                right--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = left, j = right - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }

                for (int i = left + 1, j = right; i < j; i++, j--) {
                    char c5 = s.charAt(i), c6 = s.charAt(j);
                    if (c5 != c6) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }

        return true;
    }
}
