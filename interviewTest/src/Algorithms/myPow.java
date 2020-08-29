package Algorithms;

/*LeetCode 50. Pow(x, n)
实现pow(x, n)，即计算 x 的 n 次幂函数。

        示例 1:

        输入: 2.00000, 10
        输出: 1024.00000
        示例2:

        输入: 2.10000, 3
        输出: 9.26100
        示例3:

        输入: 2.00000, -2
        输出: 0.25000
        解释: 2-2 = 1/22 = 1/4 = 0.25
        说明:

        -100.0 <x< 100.0
        n是 32 位有符号整数，其数值范围是[−231,231− 1] 。*/

public class myPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? myPowHelper(x, N) : 1.0 / myPowHelper(x, -N);
    }

    public double myPowHelper(double x, long N){
        if(N == 0){
            return 1.0;
        }

        double y = myPowHelper(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
