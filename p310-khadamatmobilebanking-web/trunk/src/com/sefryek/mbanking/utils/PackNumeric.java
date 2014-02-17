package com.sefryek.mbanking.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 6/10/13
 * Time: 5:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class PackNumeric {
    public static String packNumeric(String numericStr){
        int n;
        String packedStr="";
        int len = numericStr.length();
        for(int i=0;i<len;i+=2){
            n=Integer.parseInt(numericStr.substring(i, i+2));
            packedStr+=((char)n);
        }
        return packedStr;
    }

    public static String packNumeric2(String numericStr){
        int len = numericStr.length();
        if(len!=((len/2)*2))
            return "p"+ packNumeric("0"+ numericStr);
        else
        return "u"+ packNumeric(numericStr);
              }

    public static String unpackNumeric(String packedStr){
        int n;
        String numericStr="";
        int len = packedStr.length();
        for(int i=0;i<len;i++){
            n=packedStr.charAt(i);
            if(n<10)
                numericStr+="0"+String.valueOf(n);
            else
                numericStr+=String.valueOf(n);
        }
        return numericStr;
    }

    public static String unpackNumeric2(String packedStr){
       if(packedStr.startsWith("p"))
            return unpackNumeric(packedStr.substring(1).substring(1));
        else
            return unpackNumeric(packedStr.substring(1));
    }


}
