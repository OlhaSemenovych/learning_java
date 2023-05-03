package module13.jsonplaceholder;

import com.google.gson.Gson;
import utils.FilePathUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class JsonPlaceholder {

    private static final String URL = "https://jsonplaceholder.typicode.com";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String NEW_USER_FILE = "newUser.json";
    private static final String UPDATE_USER_FILE = "updateUser.json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final Gson GSON = new Gson();
    public static final String JSON = "application/json; charset=UTF-8";

    public void createUser() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .header(CONTENT_TYPE, JSON)
                .POST(HttpRequest.BodyPublishers
                        .ofFile(FilePathUtils
                                .getFilePath(NEW_USER_FILE)))
                .build();
        getResponse(request);
    }

    public void updateUser(int userId) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .PUT(HttpRequest.BodyPublishers
                        .ofFile(FilePathUtils
                                .getFilePath(UPDATE_USER_FILE)))
                .build();
        getResponse(request);
    }

    public void deleteUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .DELETE()
                .build();
        getResponse(request);
    }

    public void getResponse(HttpRequest request) throws IOException, InterruptedException {
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        System.out.println(GSON.fromJson(response.body(), User.class));
    }


    public void getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        System.out.println(Arrays.toString(GSON.fromJson(response.body(), User[].class)));
    }

    public void getUserById(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .GET()
                .build();
        getResponse(request);
    }

    public void getUserByUserName(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users?username=" + userName))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        System.out.println(response.body());

    }

}

