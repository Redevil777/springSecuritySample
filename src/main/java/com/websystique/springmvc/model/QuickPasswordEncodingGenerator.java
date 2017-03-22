package com.websystique.springmvc.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by User on 22.03.2017.
 */
public class QuickPasswordEncodingGenerator {
    public static void main(String[] args) {
        String password = "admin";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
