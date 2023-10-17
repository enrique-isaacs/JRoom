package com.enrique.JRoom.jRoom.entities.chatRoom;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class RoomCode {

    public static String generateUniqueCode(int length) {
        long timestamp = System.currentTimeMillis();
        String randomValue = UUID.randomUUID().toString();
        String data = timestamp + randomValue;

        String uniqueCode = hashString(data);

        return uniqueCode.substring(0, length);
    }

    public static String hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

