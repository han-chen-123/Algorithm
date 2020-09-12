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
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0 || tLen == 0 || sLen < tLen){
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        //定义滑动窗口中出现字符的频数以及t中字符出现的频数
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for (Character c : charArrayT){
            tFreq[c]++;
        }

        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;

        while (right < sLen){
            //若右指针的字符在t中没有，则继续滑动右指针
            if (tFreq[charArrayS[right]] == 0){
                right++;
                continue;
            }

            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }

            winFreq[charArrayS[right]]++;
            right++;

            //当distance中包含了t中所有的字符，则左指针右移
            while (distance == tLen){

                if (right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[charArrayS[left]] == 0){
                    left++;
                    continue;
                }

                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    distance--;
                }

                winFreq[charArrayS[left]]--;
                left++;
            }
        }

        if (minLen == sLen + 1){
            return "";
        }

        return s.substring(begin, begin + minLen);
    }
}
