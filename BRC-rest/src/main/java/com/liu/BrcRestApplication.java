package com.liu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class BrcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrcRestApplication.class, args);
	}
}
