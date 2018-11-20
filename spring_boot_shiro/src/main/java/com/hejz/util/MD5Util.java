package com.hejz.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author 何建哲
 * @date 2018/11/20 16:34
 */
public class MD5Util {
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        String username = "admin";
        String password = "admin";
        Object obj = new SimpleHash(hashAlgorithmName, username + password, null, hashIterations);
        System.out.println(obj);
    }
}
