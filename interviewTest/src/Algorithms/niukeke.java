package Algorithms;

import java.util.*;

public class niukeke {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(zishoushu(n));
        }
        sc.close();

    }

    public static int zishoushu(int n){
        int count = 0;
        for (int i = 0; i <= n; i++){
            String str = String.valueOf(i);
            String sqr = String.valueOf(i * i);
            if (str.equals(sqr.substring(sqr.length() - str.length(), sqr.length()))){
                count++;
            }
        }
        return count;
    }
}
