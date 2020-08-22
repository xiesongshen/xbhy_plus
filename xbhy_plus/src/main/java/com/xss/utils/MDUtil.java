package com.xss.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author XSS
 * @date 2020/6/28
 * @desc
 */
public class MDUtil {

    //盐值
    private static final String SALT = "abc";

    public static void main(String[] args) {
        System.out.println(md5("admin"));
    }

    public static String md5(String password) {
        String result = "";
        try {
            //md5 sha
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update((password + SALT).getBytes());
            //加密后的密文（32位）
            result = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}
