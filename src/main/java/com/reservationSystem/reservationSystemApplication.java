package com.reservationSystem;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class reservationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(reservationSystemApplication.class, args);
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
    }

}
