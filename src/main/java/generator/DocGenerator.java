package generator;

import entity.Person;

/**
 * Created by vserdiuk on 5/30/2016.
 */
public interface DocGenerator {

    void generate(String templateFilePate, String outputFilePath, Person person);

}
