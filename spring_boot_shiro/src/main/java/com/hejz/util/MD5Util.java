package com.hejz.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * shiro密码重成器
 * @author 何建哲
 * @date 2018/11/20 16:34
 */
public class MD5Util {
    public static void main(String[] args) {
        String password = getPassword("admin", "admin");
        System.out.println(password);
    }

    public static String getPassword(String username,String password) {
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, username + password, null, hashIterations);
        return String.valueOf(obj);
    }
}
