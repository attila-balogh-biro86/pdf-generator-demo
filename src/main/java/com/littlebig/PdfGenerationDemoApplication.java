package com.littlebig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class PdfGenerationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGenerationDemoApplication.class, args);
	}

}
