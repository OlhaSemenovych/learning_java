package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

class JsonFormFile {

    public static final String FILE_NAME = "task2_file.txt";

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static String createJsonFromFile() throws URISyntaxException {
        ClassLoader classLoader = module10.PhoneValidator.class.getClassLoader();
        URL resource = classLoader.getResource(FILE_NAME);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());
        ArrayList<User> user = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] lines = line.trim()
                        .replaceAll(" +", " ")
                        .split(" ");
                user.add(new User(lines[0], Integer.parseInt(lines[1])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(user);
    }

    public static void createFileWithJson() {
        File file = new File("src/main/resources", "user.json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(JsonFormFile.createJsonFromFile());
            writer.flush();
        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }

}
