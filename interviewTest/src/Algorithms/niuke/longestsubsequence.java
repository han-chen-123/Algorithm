package Algorithms.niuke;

/*最长公共子串和最长公共子序列。。。傻傻烦不清楚

        举个栗子：
        str1="123ABCD456"  str2 = "ABE12345D"
        最长公共子串是：123
        最长公共子序列是：12345

        这两个都可以用动态规划，只是状态转移方程有点区别

        最长公共子序列是：
        dp[i][j] -- 表示子串str1[0...i]和子串str[0...j]的最长公共子序列
        当str1[i] == str2[j]时，dp[i][j] = dp[i-1][j-1] + 1;
        否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        最优解为dp[len1-1][len2-1];

        最长公共子串是： dp[i][j] -- 表示以str1[i]和str2[j]为结尾的最长公共子串 当str1[i] == str2[j]时，dp[i][j] = dp[i-1][j-1] + 1; 否则，dp[i][j] = 0;
        最优解为max(dp[i][j]),其中0<=i<len1, 0<=j<len2;

        so，代码如下： //求最长公共子串*/

import java.util.Scanner;
public class longestsubsequence {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        while(sc.hasNext()){
            str1 = sc.next();
            str2 = sc.next();
            System.out.println(getCommonStrLength(str1, str2));
        }
    }

    public static int getCommonStrLength(String str1, String str2){

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;	//区别在这儿
                }
            }
        }
        return dp[len1][len2];
    }
}

/*//求最长公共子序列 import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        while(sc.hasNext()){
            str1 = sc.next();
            str2 = sc.next();
            System.out.println(getCommonStrLength(str1, str2));
        }
    }

    public static int getCommonStrLength(String str1, String str2){

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);	//区别在这儿
                }
            }
        }
        return dp[len1][len2];
    }
} */
