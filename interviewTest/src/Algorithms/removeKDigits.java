package Algorithms;

/*给定一个整数，从整数当中去掉k个数字，要求剩下数字形成的新整数尽可能小。*/

public class removeKDigits {
    public static void removeKDigits(String str, int k){
        char[] c = new char[str.length() - k];

        int n = 0;
        for (int i = 0; i < str.length(); i++){
            char j = str.charAt(i);
            while (n > 0 && j < c[n - 1] && k > 0){
                k--;
                n--;
            }
            c[n++] = j;
        }

        System.out.println(c);
    }

    public static void main(String[] args) {
        removeKDigits("541270936", 3);
    }

}
