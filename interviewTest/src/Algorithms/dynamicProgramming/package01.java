package Algorithms.dynamicProgramming;

// 0 - 1背包问题/大到小遍历V
import java.util.*;

public class package01 {
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

                /*int[][] dp = new int[N + 1][V + 1];

                for (int i = 1; i <= N; i++){
                    for (int j = 0; j <= V; j++){
                        dp[i][j] = dp[i - 1][j];
                        if (j - v[i - 1] >= 0){
                            dp[i][j] = Math.max(dp[i - 1][j - v[i - 1]] + w[i - 1], dp[i - 1][j]);
                        }
                    }
                }*/

                int[] dp = new int[V + 1];
                for (int i = 0; i < N; i++){

                    //体积从大到小遍历
                    for (int j = V; j >= 0; j--){
                        if (j - v[i] >= 0){
                            dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                        }
                    }
                }

                System.out.println(dp[V]);

            }

        }

}
