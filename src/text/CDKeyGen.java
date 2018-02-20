package text;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
cd-key的实现方式如下：
    1、凯撒密码加盐
    2、hd5加盐
    注：salt为某段系统时间
    未完成
 */

public class CDKeyGen {

    public static String encoding( String str, long slat ) throws NoSuchAlgorithmException {

        byte[] btInput = str.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();

        System.out.println("未加盐+"+md.toString());

        String salted = md.toString() + slat;
        mdInst.update( salted.getBytes() );

        String cdkey = mdInst.digest().toString();

        return cdkey;
    }




    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("真正的密码是 + " + encoding("helloworld",System.currentTimeMillis()));

    }
}
