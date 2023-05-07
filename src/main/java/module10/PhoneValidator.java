package module10;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
class PhoneValidator {

    public static final String FILE_NAME = "task1_file.txt";

    public static void phoneValidatorFromFile() throws URISyntaxException {
        ClassLoader classLoader = PhoneValidator.class.getClassLoader();
        URL resource = classLoader.getResource(FILE_NAME);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("^\\d{3}-\\d{3}-\\d{4}$")
                        || line.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$")) {
                    log.info(line);
                }
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

}
