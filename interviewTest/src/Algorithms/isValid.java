package Algorithms;

/*LeetCode 20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

        示例 1:

        输入: "()"
        输出: true
        示例2:

        输入: "()[]{}"
        输出: true
        示例3:

        输入: "(]"
        输出: false
        示例4:

        输入: "([)]"
        输出: false
        示例5:

        输入: "{[]}"
        输出: true*/

import java.util.HashMap;
import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        if (s.length() == 0 || s == null){
            return false;
        }

        if (s.length() % 2 != 0){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(c);
            }else if ( !map.get(stack.pop()).equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
