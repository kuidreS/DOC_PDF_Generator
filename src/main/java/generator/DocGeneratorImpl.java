package generator;

import entity.Person;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.*;

/**
 * Created by vserdiuk on 5/30/2016.
 */
public class DocGeneratorImpl implements DocGenerator {

    public void generate(String templateFilePate, String outputFilePath, Person person) {
        try
        {
            // doc generator
            // 1) Load Docx file by filling Freemarker template engine and cache
            // it to the registry
            InputStream in = DocGeneratorImpl.class.getResourceAsStream(templateFilePate);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);

            // 2) Create context Java model
            IContext context = report.createContext();
            context.put("person", person);

            // 3) Generate report by merging Java model with the Docx
            OutputStream out = new FileOutputStream(new File(outputFilePath));
            report.process(context, out);
            System.out.println("The doc file with name " + outputFilePath + " has been generated");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }

}
