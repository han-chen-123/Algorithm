package Algorithms;
import java.util.HashMap;

/*给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

        为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

        例如:

        输入:
        A = [ 1, 2]
        B = [-2,-1]
        C = [-1, 2]
        D = [ 0, 2]

        输出:
        2

        解释:
        两个元组如下:
        1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
        2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0*/

public class fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i ++){
            for (int j = 0; j < B.length; j ++){
                int sumAB = A[i] + B[j];
                if (map.containsKey(sumAB)){
                    map.put(sumAB, map.get(sumAB)+1);
                }else{
                    map.put(sumAB, 1);
                }
            }
        }

        for (int i = 0; i < C.length; i ++){
            for (int j = 0; j < D.length; j ++){
                int sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)){
                    result += map.get(sumCD);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        fourSumCount test = new fourSumCount();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};

        System.out.println(test.fourSumCount(A,B,C,D));
    }
}
