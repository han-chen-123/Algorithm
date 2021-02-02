package Algorithms.imooc;

/*17. 电话号码的字母组合
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





        示例 1：

        输入：digits = "23"
        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        示例 2：

        输入：digits = ""
        输出：[]
        示例 3：

        输入：digits = "2"
        输出：["a","b","c"]


        提示：

        0 <= digits.length <= 4
        digits[i] 是范围 ['2', '9'] 的一个数字。*/

import java.util.ArrayList;
import java.util.List;

public class topic81 {
    public String[] nums = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return res;
        }

        letterCombinationsHelper(digits, 0, "");
        return res;
    }

    private void letterCombinationsHelper(String digits, int index, String sDone){
        if (digits.length() == index){
            res.add(sDone);
            return;
        }

        char c = digits.charAt(index);
        String letters = nums[c - '0'];

        for (int i = 0; i < letters.length(); i++){
            letterCombinationsHelper(digits, index + 1, sDone + letters.charAt(i));
        }

    }


    /*93. 复原IP地址
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

    有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

    例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。



    示例 1：

    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    示例 2：

    输入：s = "0000"
    输出：["0.0.0.0"]
    示例 3：

    输入：s = "1111"
    输出：["1.1.1.1"]
    示例 4：

    输入：s = "010010"
    输出：["0.10.0.10","0.100.1.0"]
    示例 5：

    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]*/

    public List<String> restoreIpAddresses(String s) {

    }


    /*131. 分割回文串
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

    返回 s 所有可能的分割方案。

    示例:

    输入: "aab"
    输出:
            [
            ["aa","b"],
            ["a","a","b"]
            ]*/

    public List<List<String>> partition(String s) {

    }
}
