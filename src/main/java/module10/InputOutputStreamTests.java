package module10;

import java.net.URISyntaxException;

import static module10.CountWordFrequency.countWordFrequency;
import static module10.JsonFormFile.createFileWithJson;
import static module10.PhoneValidator.phoneValidatorFromFile;

public class InputOutputStreamTests {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("""
                ----- Get only valid phones from file -----
                * (xxx) xxx-xxxx
                * xxx-xxx-xxxx""");
        phoneValidatorFromFile();
        System.out.println("----- Create list if users to user.json file -----");
        createFileWithJson();
        System.out.println("The file was successfully created, please find file by name 'user.json'");
        System.out.println("----- Counter of word frequency in the file -----");
        countWordFrequency();
    }

}
