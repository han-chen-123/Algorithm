package Algorithms.dynamicProgramming;

// 多重背包问题/大到小遍历V

import java.util.Scanner;

public class packageMutiple {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                int N = sc.nextInt();
                int V = sc.nextInt();
                int[] v = new int[N];
                int[] w = new int[N];
                int[] s = new int[N];
                for (int i = 0; i < N; i++){
                    v[i] = sc.nextInt();
                    w[i] = sc.nextInt();
                    s[i] = sc.nextInt();
                }

                int[][] dp = new int[N + 1][V + 1];

                for (int i = 1; i <= N; i++){
                    for (int j = 0; j <= V; j++){
                        for (int k = 0; k <= s[i - 1]; k++){
                            if (j - k*v[i - 1] >= 0){
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k*v[i - 1]] + k*w[i - 1]);
                            }
                        }
                    }
                }

                System.out.println(dp[N][V]);

                /*int[] dp = new int[V + 1];
                for (int i = 1; i <= N; i++){
                    for (int j = V; j >= 0; j--){
                        for (int k = 0; k <= s[i - 1]; k++){
                            if (j >= k*v[i - 1]){
                                dp[j] = Math.max(dp[j], dp[j - k*v[i - 1]] + w[i - 1]);
                            }
                        }
                    }
                }
                System.out.println(dp[V]);*/

            }

        }

}
