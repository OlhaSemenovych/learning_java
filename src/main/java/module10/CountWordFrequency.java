package module10;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
class CountWordFrequency {

    public static final String FILE_NAME = "task3_file.txt";

    public static Map<String, Integer> countWordFrequency() throws URISyntaxException {
        ClassLoader classLoader = module10.PhoneValidator.class.getClassLoader();
        URL resource = classLoader.getResource(FILE_NAME);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            StringBuilder dataFromFile = new StringBuilder();
            Map<String, Integer> mp = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                dataFromFile.append(line).append(" ");
            }
            String[] words = dataFromFile.toString().split(" ");

            for (int i = 0; i < words.length; i++) {
                if (mp.containsKey(words[i])) {
                    mp.put(words[i], mp.get(words[i]) + 1);
                } else {
                    mp.put(words[i], 1);
                }
            }
            mp.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> log.info(entry.getKey() + " " + entry.getValue()));
        } catch (
                IOException e) {
            log.info(e.getMessage());
        }
        return Collections.emptyMap();
    }

}
