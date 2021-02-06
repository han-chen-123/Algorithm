package Algorithms.imooc;

/*01背包
        有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。

        第 i 件物品的体积是 vi，价值是 wi。

        求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
        输出最大价值*/

public class topic95 {
    private int[][] memo;
    public int bag01(int[] W, int[] V, int C){
        memo = new int[W.length][C + 1];
        return bag01Helper(W, V, W.length, C);
    }

    public int bag01Helper(int[] W, int[] V, int index, int c){
        //[0 ... index] 到index时背包的容量为c
        if (index < 0 || c <= 0){
            return 0;
        }

        if (memo[index][c] != 0){
            return memo[index][c];
        }

        int res = bag01Helper(W, V, index - 1, c);
        if (c >= W[index]){
            res = Math.max(res, V[index] + bag01Helper(W, V, index - 1, c - W[index]));
        }

        memo[index][c] = res;
        return res;
    }

    public int bag012(int[] W, int[] V, int C){
        //f(物品个数，背包容量)
        if (W.length == 0){
            return 0;
        }

        int[][] dp = new int[W.length][C + 1];

        for (int j = 0; j <= C; j++){
            dp[0][j] = (j >= W[0] ? V[0] : 0);
        }

        for (int i = 1; i < W.length; i++){
            for (int j = 0; j <= C; j++){
                dp[i][j] = dp[i - 1][j];
                if (W[i] < j){
                    dp[i][j] = Math.max(dp[i][j], V[i] + dp[i - 1][j - W[i]]);
                }
            }
        }

        return dp[W.length - 1][C];

    }
}
