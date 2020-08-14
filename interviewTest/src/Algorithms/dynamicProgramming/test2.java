package Algorithms.dynamicProgramming;

import java.util.*;

public class test2{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            int totalMp = sc.nextInt();
            int totalCD = sc.nextInt();
            int[][][] dp = new int[count][totalMp][totalCD];

            for(int i = 0; i < count; i++){
                for(int j = 0; j < totalMp; j++){
                    for(int k = 0; k < totalCD; k++){
                        dp[0][j][k] = 0;

                    }
                }
            }

        }

        sc.close();
    }

}
