package com.test.soapwebservices.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.soapwebservices.POJO.ReqRes.Sampleservicers;

public class Main {
    public static void main(String[] args) {
        Sampleservicers sampleservicers = Sampleservicers.builder()
                .errorCode("400")
                .errorMsg("Duplicate Service Id")
                .trxId("c6714ec0-b379-11e9-889b-7f7167f4f72d")
                .build();

        // Panggil metode untuk mengonversi objek Sampleservicers ke JSON
        String jsonString = convertSampleservicersToJson(sampleservicers);

        // Tampilkan hasil konversi
        System.out.println(jsonString);
    }

    public static String convertSampleservicersToJson(Sampleservicers sampleservicers) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(sampleservicers);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
