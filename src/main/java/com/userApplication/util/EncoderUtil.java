package com.userApplication.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderUtil {

   static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public static String encodedString(String plainText){
        return bCryptPasswordEncoder.encode(plainText);
    }




}
