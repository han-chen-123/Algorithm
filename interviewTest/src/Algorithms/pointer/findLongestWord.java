package Algorithms.pointer;

/*LeetCode 524. 通过删除字母匹配到字典里最长单词
        给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

        示例 1:

        输入:
        s = "abpcplea", d = ["ale","apple","monkey","plea"]

        输出:
        "apple"
        示例 2:

        输入:
        s = "abpcplea", d = ["a","b","c"]

        输出:
        "a"*/

import java.util.List;

public class findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String res = "";

        int s_left = 0, d_left = 0;
        for (String d1 : d){
            s_left = 0;
            d_left = 0;
            while(s_left < s.length() && d_left < d1.length()){
                if (s.charAt(s_left) == d1.charAt(d_left)){
                    s_left++;
                    d_left++;
                    continue;
                }else {
                    s_left++;
                }
            }

            if (d_left == d1.length()){
                if ((d1.length() > res.length()) || (d1.length() == res.length() && res.compareTo(d1) > 0)){
                    res = d1;
                }
            }
        }

        return res;
    }
}
