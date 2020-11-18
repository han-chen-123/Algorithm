package Algorithms.dynamicProgramming;

// 无限背包问题/完全背包问题

import java.util.Scanner;

public class packageInfinite {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                int N = sc.nextInt();
                int V = sc.nextInt();
                int[] v = new int[N];
                int[] w = new int[N];
                for (int i = 0; i < N; i++){
                    v[i] = sc.nextInt();
                    w[i] = sc.nextInt();
                }

                int[] dp = new int[V + 1];

                for (int i = 0; i < N; i++){
                    for (int j = 0; j <= V; j++){
                        if (j - v[i] >= 0){
                            dp[j] = Math.max(dp[j - v[i]] + w[i], dp[j]);
                        }
                    }
                }

                System.out.println(dp[V]);

            }

        }

}
