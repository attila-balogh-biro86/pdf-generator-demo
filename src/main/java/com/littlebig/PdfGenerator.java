package com.littlebig;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import jakarta.annotation.PostConstruct;

@Component
public class PdfGenerator {

  private static final Logger LOGGER = Logger.getLogger(PdfGenerator.class.getName());

  private final SpringTemplateEngine templateEngine;

  @Autowired
  public PdfGenerator(SpringTemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  public OutputStream generatePdfContent(String templateName, Map<String, Object> model) throws FileNotFoundException {
    Context context = new Context();
    model.keySet().forEach(key -> context.setVariable(key, model.get(key)));
    final String hydratedHtml = templateEngine.process(templateName, context);
    return generatePdfFromHtml(hydratedHtml);
  }

   private OutputStream generatePdfFromHtml(String html) throws FileNotFoundException {

    String outputFolder = System.getProperty("java.io.tmpdir") + File.separator + "demo.pdf";

    LOGGER.log(Level.INFO,"Generating PDF location {0}" , outputFolder);
    OutputStream outputStream = new FileOutputStream(outputFolder);
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocumentFromString(html);
    renderer.layout();
    renderer.createPDF(outputStream);

    return outputStream;
  }
}
