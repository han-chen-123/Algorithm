package Algorithms;

/*LeetCode 44. 通配符匹配
给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。

        '?' 可以匹配任何单个字符。
        '*' 可以匹配任意字符串（包括空字符串）。
        两个字符串完全匹配才算匹配成功。

        说明:

        s可能为空，且只包含从a-z的小写字母。
        p可能为空，且只包含从a-z的小写字母，以及字符?和*。
        示例1:

        输入:
        s = "aa"
        p = "a"
        输出: false
        解释: "a" 无法匹配 "aa" 整个字符串。
        示例2:

        输入:
        s = "aa"
        p = "*"
        输出: true
        解释:'*' 可以匹配任意字符串。
        示例3:

        输入:
        s = "cb"
        p = "?a"
        输出: false
        解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
        示例4:

        输入:
        s = "adceb"
        p = "*a*b"
        输出: true
        解释:第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
        示例5:

        输入:
        s = "acdcb"
        p = "a*c?b"
        输出: false*/


public class isMatch {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }else {
                break;
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
