package com.aguerrerodev.hotelreservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HotelReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationsApplication.class, args);
	}

}
