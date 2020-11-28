package Algorithms.niuke;

import java.util.*;
public class bu0{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() > 8){
                System.out.println(sb.substring(0, 8));
                sb.delete(0, 8);
            }
            while (sb.length() > 0 && sb.length() < 8){
                sb.append("0");
            }
            if(sb.length() == 8) System.out.println(sb);
        }
    }
}
