package generator;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Created by vserdiuk on 5/30/2016.
 */
public class PdfGeneratorImpl implements PdfGenerator {

    public void generate(String inputFilePath, String outputFilePath) {
        try {
            //pdf generator
            // 1) Load DOCX into XWPFDocument
            InputStream is = new FileInputStream(new File(
                    inputFilePath));
            XWPFDocument document = new XWPFDocument(is);

            // 2) Prepare Pdf options
            PdfOptions options = PdfOptions.create();

            // 3) Convert XWPFDocument to Pdf
            OutputStream os = new FileOutputStream(new File(
                    outputFilePath));
            PdfConverter.getInstance().convert(document, os, options);
            System.out.println("The doc file with name " + outputFilePath + " has been generated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
