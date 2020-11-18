package Algorithms.dynamicProgramming;
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。

        示例 1：

        输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。
        示例 2：

        输入: "cbbd"
        输出: "bb"*/

public class longestPalindrome {
    static int count = 0;

    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;

        String res = "";
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int i = 1;i < len;i ++){
            for(int j = 0;j <= i;j ++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j < 3) {
                        dp[i][j] = true;
                    } else{
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if(i - j >= count && dp[i][j]){
                    count = i - j + 1;
                    res = s.substring(j,i+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestPalindrome test = new longestPalindrome();
        System.out.println(test.longestPalindrome("abba"));
        System.out.println(count);
    }
}
