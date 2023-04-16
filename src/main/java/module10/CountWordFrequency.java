package module10;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class CountWordFrequency {

    public static final String FILE_NAME = "task3_file.txt";

    public static void countWordFrequency() throws URISyntaxException {
        ClassLoader classLoader = module10.PhoneValidator.class.getClassLoader();
        URL resource = classLoader.getResource(FILE_NAME);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            StringBuilder dataFromFile = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                dataFromFile.append(line).append(" ");
            }
            String[] words = dataFromFile.toString().split(" ");
            Map<String, Integer> mp = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (mp.containsKey(words[i])) {
                    mp.put(words[i], mp.get(words[i]) + 1);
                } else {
                    mp.put(words[i], 1);
                }
            }

            for (Map.Entry<String, Integer> entry :
                    mp.entrySet()) {
                System.out.println(entry.getKey() +
                        " " + entry.getValue());
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
