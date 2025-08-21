package org.fastcampus.auth.domain;

import java.security.SecureRandom;

public class RandomTokenGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 16;
    private static final SecureRandom secureRandom = new SecureRandom();

    private RandomTokenGenerator(){

    }

    public static String generateToken(){

        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        for(int i = 0; i<16;i++){
            token.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
        }

        return token.toString();
    }

}
