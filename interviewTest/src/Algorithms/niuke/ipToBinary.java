package Algorithms.niuke;

import java.util.*;

public class ipToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(str));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String str){
        String[] s = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++){
            StringBuilder sss = new StringBuilder();
            sss.append(Long.toBinaryString(Long.valueOf(s[i])));

            while(sss.length() < 8){
                sss.insert(0, 0);
            }

            sb.append(sss);
        }
        return Long.parseLong(sb.toString(), 2);
    }

    public static String numToIp(long n){
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        sb.append(Long.toBinaryString(n));
        while(sb.length() < 32){
            sb.insert(0, 0);
        }

        for (int i = 0; i < 4; i++){
            String temp = sb.substring(i * 8, i * 8 + 8);
            numSb.append(Long.valueOf(temp, 2));
            numSb.append(".");
        }

        numSb.deleteCharAt(numSb.length() - 1);

        return numSb.toString();
    }
}

