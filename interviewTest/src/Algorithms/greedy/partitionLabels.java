package Algorithms.greedy;

/*LeetCode 763. 划分字母区间
        字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。



        示例：

        输入：S = "ababcbacadefegdehijhklij"
        输出：[9,7,8]
        解释：
        划分结果为 "ababcbaca", "defegde", "hijhklij"。
        每个字母最多出现在一个片段中。
        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。*/

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++){
            index[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++){
            end = Math.max(end, index[S.charAt(i) - 'a']);
            if (i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

}
