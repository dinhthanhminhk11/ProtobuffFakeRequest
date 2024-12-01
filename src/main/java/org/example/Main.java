package org.example;

import org.example.model.PhoneNumber;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PhoneNumber phoneNumber = new PhoneNumber.Builder().iso2CountryCode("vn").subscriberNumber("0375784487").build();


        byte[] encodedBytes = PhoneNumber.ADAPTER.encode(phoneNumber);
        System.out.println("buffer : " + Arrays.toString(encodedBytes));
//        String hexString = bytesToHex(encodedBytes);
//        Log.e("MinhTag", "Hex String: " + hexString);
        try {
            PhoneNumber decodedPhoneNumber = PhoneNumber.ADAPTER.decode(encodedBytes);
            System.out.println("buffer decrypt: " + decodedPhoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}