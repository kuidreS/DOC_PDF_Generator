import entity.Person;
import generator.DocGenerator;
import generator.DocGeneratorImpl;
import generator.PdfGenerator;
import generator.PdfGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vserdiuk on 5/30/2016.
 */

public class App {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe");
        List<String> contacts = new ArrayList<String>();
        contacts.add("email");
        contacts.add("skype");
        contacts.add("phone");
        person.setContacts(contacts);

        //generate docx according to template
        DocGenerator docGenerator = new DocGeneratorImpl();
        docGenerator.generate("/template.docx", "out.docx", person);

        //generate pdf according to template
        PdfGenerator pdfGenerator = new PdfGeneratorImpl();
        pdfGenerator.generate("out.docx", "out.pdf");
    }
}
