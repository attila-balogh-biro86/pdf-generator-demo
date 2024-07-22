package com.littlebig;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.util.Assert;

@SpringBootTest
class PdfGenerationDemoApplicationTests {

	@Autowired
	private PdfGenerator pdfGenerator;

	@Autowired
	private MessageSource messageSource;

	@Test
	void testDemoPdfGenerationEN() throws FileNotFoundException {

		OutputStream stream = pdfGenerator.generatePdfContent("demo.html", Map.of("welcomeMessage", messageSource.getMessage("welcomeMessage",null, Locale.ENGLISH)));
		Assertions.assertNotNull(stream);
	}

	@Test
	void testDemoPdfGenerationHU() throws FileNotFoundException {

		OutputStream stream = pdfGenerator.generatePdfContent("demo.html", Map.of("welcomeMessage", messageSource.getMessage("welcomeMessage",null, Locale.of("HU"))));
		Assertions.assertNotNull(stream);
	}

}
