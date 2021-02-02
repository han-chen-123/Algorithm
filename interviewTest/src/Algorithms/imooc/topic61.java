package Algorithms.imooc;

/*20. 有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。


        示例 1：

        输入：s = "()"
        输出：true
        示例 2：

        输入：s = "()[]{}"
        输出：true
        示例 3：

        输入：s = "(]"
        输出：false
        示例 4：

        输入：s = "([)]"
        输出：false
        示例 5：

        输入：s = "{[]}"
        输出：true


        提示：

        1 <= s.length <= 104
        s 仅由括号 '()[]{}' 组成*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class topic61 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    /*150. 逆波兰表达式求值
    根据 逆波兰表示法，求表达式的值。

    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。



    说明：

    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。


    示例 1：

    输入: ["2", "1", "+", "3", "*"]
    输出: 9
    解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
    示例 2：

    输入: ["4", "13", "5", "/", "+"]
    输出: 6
    解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6*/

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i ++){
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a = stack.pop();
                    stack.push(stack.pop() - a); //第二个栈顶减第一个栈顶
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int b = stack.pop();
                    stack.push(stack.pop() / b); //第二个栈顶除以第一个栈顶
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }

        return stack.pop();
    }
}
