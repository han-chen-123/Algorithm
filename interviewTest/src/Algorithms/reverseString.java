package Algorithms;

public class reverseString {
    public String reverseString(String str){
        if (str.length() == 0 || str == null) return str;
        return reverseString(str.substring(1)) + str.charAt(0);

        //int
        /*int input = sc.nextInt();

        int res = 0;
        while(input != 0){
            int pop = input % 10;
            input /= 10;
            res = res * 10 + pop;*/
        }
}
