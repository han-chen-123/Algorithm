package Algorithms.imooc;

/*454. 四数相加 II
        给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

        为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

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

import java.util.*;

public class topic45 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++){
            for (int j = 0; j < D.length; j++){
                if (map.containsKey(C[i] + D[i])){
                    map.put(C[i] + D[i], map.get(C[i] + D[i]) + 1);
                }else{
                    map.put(C[i] + D[i], 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (map.containsKey(-A[i] - B[j])){
                    res += map.get(-A[i] - B[j]);
                }
            }
        }

        return res;
    }

    /*49. 字母异位词分组
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    示例:

    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出:
            [
            ["ate","eat","tea"],
            ["nat","tan"],
            ["bat"]
            ]*/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String newStr = String.valueOf(c);
            if (!map.containsKey(newStr)){
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
