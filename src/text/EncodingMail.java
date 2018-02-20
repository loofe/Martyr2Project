package text;

import java.util.Scanner;
/*
这是一个加密解密类，主要实现了左移一位的凯撒密码

 */
public class EncodingMail {

    public static void main(String[] args) {



        System.out.println("please input words in Eng");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);

        String encoded =  encode(str);
        System.out.println(" en coding Message ：" + encoded);

        System.out.println("decoding : " + decoding(encoded));


    }


    public static String encode (String str) {
        char[] content = str.toCharArray();

        for (int i = 0; i < content.length; i++) {
            if ( content[i] == '9') {
                content[i] = '0';

            }else if ( content[i] >= '0' && content[i] < '9' ) {
                content[i] += 1;
            }else if ( content[i] == 'z' ){
                content[i] = 'a';
            }else if ( content[i] == 'Z' ){
                content[i] = 'A';
            }else if ( (content[i] >= 'a' && content[i] < 'z') ||(content[i] >= 'A' && content[i] < 'Z' ) ) {
                content[i] += 1;
            }else {
                continue;
            }
        }

        return new String(content);
    }

    public static String decoding (String str) {
        char[] content = str.toCharArray();

        for (int i = 0; i < content.length; i++) {
            if ( content[i] == '0') {
                content[i] = '9';
            }else if ( content[i] > '0' && content[i] <= '9' ) {
                content[i] -= 1;
            }else if ( content[i] == 'a'  ){
                content[i] = 'z';
            }else if ( content[i] == 'A'  ){
                content[i] = 'Z';
            }else if ( content[i] > 'a' && content[i] <= 'z' ) {
                content[i] -= 1;
            }else if ( content[i] > 'A' && content[i] <= 'Z' ) {
                content[i] -= 1;
            }else {
                continue;
            }
        }

        return new String(content);
    }

}
