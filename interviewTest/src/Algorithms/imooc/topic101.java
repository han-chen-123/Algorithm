package Algorithms.imooc;

/*455. 分发饼干
        假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

        对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。


        示例 1:

        输入: g = [1,2,3], s = [1,1]
        输出: 1
        解释:
        你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
        虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
        所以你应该输出1。
        示例 2:

        输入: g = [1,2], s = [1,2,3]
        输出: 2
        解释:
        你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
        你拥有的饼干数量和尺寸都足以让所有孩子满足。
        所以你应该输出2.*/

import java.util.Arrays;

public class topic101 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gMost = g.length - 1;
        int sMost = s.length - 1;
        int res = 0;

        while (gMost >= 0 && sMost >= 0){
            if (g[gMost] <= s[sMost]){
                res++;
                sMost--;
                gMost--;
            }else {
                gMost--;
            }
        }

        return res;
    }


    /*392. 判断子序列
    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

    进阶：

    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

    致谢：

    特别感谢 @pbrother 添加此问题并且创建所有测试用例。



    示例 1：

    输入：s = "abc", t = "ahbgdc"
    输出：true
    示例 2：

    输入：s = "axc", t = "ahbgdc"
    输出：false*/

    public boolean isSubsequence(String s, String t) {

    }
}
