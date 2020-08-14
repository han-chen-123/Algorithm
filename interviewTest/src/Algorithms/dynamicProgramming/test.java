package Algorithms.dynamicProgramming;


import java.util.*;

public class test{
    public static Hashtable<Character, Integer> ta = new Hashtable<Character, Integer>(){};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ta.put('a', 1);ta.put('b', 2);ta.put('c', 3);ta.put('d', 4);ta.put('e', 5);ta.put('f', 6);
        ta.put('g', 7);ta.put('h', 8);ta.put('i', 9);ta.put('j', 10);ta.put('k', 11);ta.put('l', 12);
        ta.put('m', 13);ta.put('n', 14);ta.put('o', 15);ta.put('p', 16);ta.put('q', 17);ta.put('r', 18);
        ta.put('s', 19);ta.put('t', 20);ta.put('u', 21);ta.put('v', 22);ta.put('w', 23);ta.put('x', 24);
        ta.put('y', 25);ta.put('z', 26);

        while(sc.hasNext()){
            String jiabing = sc.next();
            String[] s = new String[5];

            for(int i = 1; i < 6; i++){
                s[i] = sc.next();
                if(luckyNo(jiabing) == luckyNo(s[i])){
                    System.out.println(s[i]);
                }
                else{
                    if(luckyNo(jiabing) - luckyNo(s[i]) < luckyNo(jiabing) - luckyNo(s[i + 1])){
                        System.out.println(s[i]);
                    }
                }
            }
        }

        sc.close();
    }

    public static int luckyNo(String str){
        int lucky = 0;
        String lowerStr = str.toLowerCase();
        char[] c = lowerStr.toCharArray();
        for(int i = 0; i < c.length; i++){
            lucky += ta.get(c[i]);
        }

        return lucky;
    }

}