package Algorithms.slidingWindow;

/*LeetCode 76. 最小覆盖子串
给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

        示例：

        输入：S = "ADOBECODEBANC", T = "ABC"
        输出："BANC"

        提示：

        如果 S 中不存这样的子串，则返回空字符串 ""。
        如果 S 中存在这样的子串，我们保证它是唯一的答案。*/


public class minWindow {
    public String minWindow(String s, String t) {
        String res = "";
        int[] window = new int[128];
        int[] need = new int[128];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        if (s == null || ss.length == 0 || t == null || tt.length == 0){
            return " ";
        }

        for (int i = 0; i < tt.length; i++){
            need[tt[i]]++;
        }

        int i = 0, j = 0, count = 0;
        int min = ss.length;
        while (j < ss.length){
            char cc = ss[j];
            window[cc]++;
            if (window[cc] <= need[cc]) count++;
            while (count == tt.length){
                if (j - i + 1 <= min){
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if (window[ss[i]] < need[ss[i]]) count--;
                i++;
                if (i >= ss.length) break;
            }
            j++;
        }

        return res;
    }
}
