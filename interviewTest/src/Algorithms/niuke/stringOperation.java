package Algorithms.niuke;

import java.util.*;
public class stringOperation{


    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){

            String str=scanner.nextLine();
            int res=calculate(str);
            System.out.println(res);
        }
    }

    public static int calculate(String strExpression) {
        //获得中缀表达式

        List<String> infixExpression = getExpressionList(strExpression);
        Deque<Integer> stack=new LinkedList<>();
        //根据中缀表达式获得后缀表达式
        List<String> suffixExpression = getSuffixExpression(infixExpression);
        for(String expression:suffixExpression){
            //当匹配到数字
            if(expression.matches("\\d+")){
                stack.push(Integer.parseInt(expression));
            }else {//当匹配到操作符

                Integer int01 = stack.pop();
                Integer int02 = stack.pop();
                int cal = cal(int02, int01, expression);
                stack.push(cal);
            }
        }

        return stack.pop();

    }

    public static int cal(int a,int b,String c){
        int result=0;
        switch (c){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            default:
                break;
        }
        return result;
    }
    //根据前缀表达式获得后缀表达式
    public static List<String> getSuffixExpression(List<String> infixExpression){

        //用于存储后缀表达式结果
        List<String> resultList=new ArrayList<>();
        //存储临时符号
        Deque<String> tempStack=new LinkedList<>();
        for(String string:infixExpression){
            if(string.matches("\\d+")){
                resultList.add(string);
            }else if (string.matches("\\(")){
                tempStack.push("(");
            }else if (string.matches("\\)")){
                while (!(tempStack.peek().equals("("))){
                    resultList.add(tempStack.pop());
                }
                tempStack.pop();
            }else {
                while(!tempStack.isEmpty()&&priority(tempStack.peek())>=priority(string)){
                    resultList.add(tempStack.pop());
                }
                tempStack.push(string);
            }
        }

        while(!tempStack.isEmpty()){
            resultList.add(tempStack.pop());
        }
        return resultList;
    }

    public static int priority(String s){
        if(s.matches("[\\*/]")){
            return 1;
        }
        if(s.matches("[\\+-]")){
            return 0;
        }
        return -1;
    }
    //将表达式转换成集合，即中缀表达式集合
    public static List<String> getExpressionList(String string) {
        //处理负数
        string=string.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0");
        String s = string.replaceAll("[\\[\\{]", "(");
        String exp = s.replaceAll("[\\]\\}]", ")");
        List<String> list = new ArrayList<>();
        int index = 0;
        String tempStr = "";
        while (true) {
            char c = exp.charAt(index);
            if (isOperator(c)) {
                list.add(c + "");
            } else {
                tempStr = tempStr + c;

                if (index == exp.length() - 1) {
                    list.add(tempStr);
                } else {
                    if (isOperator(exp.charAt(index + 1))) {
                        list.add(tempStr);
                        tempStr="";
                    }
                }
            }
            index = index + 1;
            if (index >= exp.length()) {
                break;
            }
        }
        return list;

    }

    //判断字符是不是操作符
    public static boolean isOperator(char c) {
        return (c + "").matches("[/+-/*/{/}/(/)\\[\\]]");
    }
}
