package Algorithms.niuke;


import java.io.BufferedInputStream;
import java.util.Scanner;

public class substringString {

    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.print(res + " ");
            return ;
        } else {
            printAllSub(str, i + 1, res); // 不要下标为i+1的字符
            printAllSub(str, i + 1, res+str[i]); // 要第i+1个字符
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        String str = cin.next();
        printAllSub(str.toCharArray(), 0, "");
        cin.close();
    }
}

