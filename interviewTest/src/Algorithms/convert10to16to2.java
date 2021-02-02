package Algorithms;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigInteger;

public class convert10to16to2 {
    public static String changeFormatNumber (String number) {
        // write code here
        int need = Integer.valueOf(number);

        StringBuilder sb = new StringBuilder(8);
        String a;
        char[] b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(need != 0){
            sb = sb.append(b[need % 16]);
            need = need / 16;
        }
        a = sb.reverse().toString();

        return a + "," + Integer.toBinaryString(Integer.valueOf(number));
    }

    public static int six16To10(String s){
        BigInteger bs = new BigInteger(s, 16);
        return bs.intValue();
    }

    public static String ten10To16(int num){
        return String.format("%08X", num);
    }

}
