package com.bvgol.examples.my.string;

/**
 * Java中将一个字符与对应Ascii码互转
 * 1 byte = 8bit 可以表示 0-127
 */
public class GetCharAscii {

    /*0-9对应Ascii 48-57
     *A-Z 65-90
     *a-z 97-122
     *第33～126号(共94个)是字符，其中第48～57号为0～9十个阿拉伯数字
     */
    public static void main(String[] args) {
// System.out.println(charToByteAscii('9'));
// System.out.println(byteAsciiToChar(57));
        System.out.println(SumStrAscii("="));
        System.out.println(SumStrAscii(">"));
    }

    /**
     * 方法一：将char 强制转换为byte
     *
     * @param ch
     * @return
     */
    public static byte charToByteAscii(char ch) {
        byte byteAscii = (byte) ch;

        return byteAscii;
    }

    /**
     * 方法二：将char直接转化为int，其值就是字符的ascii
     *
     * @param ch
     * @return
     */
    public static byte charToByteAscii2(char ch) {
        byte byteAscii = (byte) ch;

        return byteAscii;
    }

    /**
     * 同理，ascii转换为char 直接int强制转换为char
     *
     * @param ascii
     * @return
     */
    public static char byteAsciiToChar(int ascii) {
        char ch = (char) ascii;
        return ch;
    }

    /**
     * 求出字符串的ASCII值和
     * 注意，如果有中文的话，会把一个汉字用两个byte来表示，其值是负数
     */
    public static int SumStrAscii(String str) {
        byte[] bytestr = str.getBytes();
        int sum = 0;
        for (int i = 0; i < bytestr.length; i++) {
            sum += bytestr[i];
        }
        return sum;
    }
}
