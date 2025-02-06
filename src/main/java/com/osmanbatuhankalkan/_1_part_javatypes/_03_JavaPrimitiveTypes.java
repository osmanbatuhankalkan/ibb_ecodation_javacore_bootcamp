package com.osmanbatuhankalkan._1_part_javatypes;

public class _03_JavaPrimitiveTypes {
    public static void main(String[] args) {

        //Primitive type: 8 tanedir. null değer alamazsınız.
        //tam sayılar(4)
        //primitive typelar küçük harfle başlar. 'String' bir primitive type DEĞİLDİR!***!
        //Byte
        byte b1 = 127;// max alacağı deger.
        System.out.println("byte: " + b1);
        //Short
        short s1 = 32767;
        System.out.println("short: " + s1);
        //int
        int i1 = 127536363;
        System.out.println("int: " + i1);
        //long
        long l1 = 1276436363633463L;
        System.out.println("long: " + l1);

        //Virgullu Sayilar (floating point)
        float f1 = 127.5f;
        System.out.println("float: " + f1);
        //Double
        double d1 = 127.5d;
        System.out.println("double: " + d1);
        //Boolean
        boolean b3=true;
        System.out.println("boolean: " + b3);
        //Char tek tırnak ile ' '
        char c1 = 'a';
        System.out.println("char: " + c1);
    }
}
