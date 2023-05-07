package module10;

import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;

import static module10.CountWordFrequency.countWordFrequency;
import static module10.JsonFormFile.createFileWithJson;
import static module10.PhoneValidator.phoneValidatorFromFile;

@Slf4j
public class InputOutputStreamTests {

    public static void main(String[] args) throws URISyntaxException {
        log.info("""
                ----- Get only valid phones from file -----
                * (xxx) xxx-xxxx
                * xxx-xxx-xxxx""");
        phoneValidatorFromFile();
        log.info("----- Create list if users to user.json file -----");
        createFileWithJson();
        log.info("The file was successfully created, please find file by name 'user.json'");
        log.info("----- Counter of word frequency in the file -----");
        countWordFrequency();
    }

}
