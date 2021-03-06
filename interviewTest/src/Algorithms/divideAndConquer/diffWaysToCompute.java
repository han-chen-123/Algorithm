package Algorithms.divideAndConquer;

/*LeetCode 241. 为运算表达式设计优先级
        给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

        示例 1:

        输入: "2-1-1"
        输出: [0, 2]
        解释:
        ((2-1)-1) = 0
        (2-(1-1)) = 2
        示例 2:

        输入: "2*3-4*5"
        输出: [-34, -14, -10, -10, 10]
        解释:
        (2*(3-(4*5))) = -34
        ((2*3)-(4*5)) = -14
        ((2*(3-4))*5) = -10
        (2*((3-4)*5)) = -10
        (((2*3)-4)*5) = 10*/

import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        return partition(input);
    }

    public List<Integer> partition(String input){
        List<Integer> res = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")){
            res.add(Integer.valueOf(input));
            return res;
        }

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for (Integer left : partition(input.substring(0, i))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            res.add(left + right);
                        }else if (input.charAt(i) == '-'){
                            res.add(left - right);
                        }else if (input.charAt(i) == '*'){
                            res.add(left * right);
                        }
                    }
                }
            }
        }

        return res;
    }
}
