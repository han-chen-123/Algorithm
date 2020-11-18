package Algorithms;

public class reverseString {
    public String reverseString(String str){
        if (str.length() == 0 || str == null) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
