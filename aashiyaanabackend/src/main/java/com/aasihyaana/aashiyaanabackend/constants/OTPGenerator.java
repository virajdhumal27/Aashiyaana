package com.aasihyaana.aashiyaanabackend.constants;

import java.util.HashMap;
import java.util.Map;

public class OTPGenerator {

    private static Map<Integer, String> otpHandler = new HashMap<>();
    private static Integer otpCounter = -1;

    public static String generateOtp() {
        String alpha = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder otp = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {
            int index = (int) (alpha.length() * Math.random());
            otp.append(alpha.charAt(index));
        }

        return otp.toString();
    }

    public static Integer addOtp(String otp) {
        otpCounter++;
        otpHandler.put(otpCounter, otp);
        return otpCounter;
    }

    public static String getOtp(Integer counter) {
        return otpHandler.get(counter);
    }

    public static void deleteOtp(Integer counter) {
        otpHandler.remove(counter);
        otpCounter--;
    }
}
