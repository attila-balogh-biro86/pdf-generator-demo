package com.littlebig;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class PdfGenerationDemoApplicationTests {

	@Autowired
	private PdfGenerator pdfGenerator;

	@Test
	void testDemoPdfGeneration() throws FileNotFoundException {

		OutputStream stream = pdfGenerator.generatePdfContent("demo.html", Map.of("welcomeMessage", "Hello World!"));
		Assertions.assertNotNull(stream);
	}

}
