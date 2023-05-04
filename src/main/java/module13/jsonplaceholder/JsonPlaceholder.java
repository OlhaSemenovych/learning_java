package module13.jsonplaceholder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.FilePathUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;

public class JsonPlaceholder {

    private static final String URL = "https://jsonplaceholder.typicode.com";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String NEW_USER_FILE = "newUser.json";
    private static final String UPDATE_USER_FILE = "updateUser.json";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final Gson GSON = new Gson();
    public static final String JSON = "application/json; charset=UTF-8";

    public User createUser() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .header(CONTENT_TYPE, JSON)
                .POST(HttpRequest.BodyPublishers
                        .ofFile(FilePathUtils
                                .getFilePath(NEW_USER_FILE)))
                .build();
        return getResponse(request);
    }

    public User updateUser(int userId) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .PUT(HttpRequest.BodyPublishers
                        .ofFile(FilePathUtils
                                .getFilePath(UPDATE_USER_FILE)))
                .build();
        return getResponse(request);
    }

    public User deleteUser(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .DELETE()
                .build();
        return getResponse(request);
    }

    public User getResponse(HttpRequest request) throws IOException, InterruptedException {
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        return GSON.fromJson(response.body(), User.class);
    }


    public Collection<User> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        Type collectionType = new TypeToken<Collection<User>>(){}.getType();
        return GSON.fromJson(response.body(), collectionType);
    }

    public User getUserById(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId))
                .header(CONTENT_TYPE, JSON)
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        return GSON.fromJson(response.body(), User.class);
    }

    public Collection<User> getUserByUserName(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users?username=" + userName))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        Type collectionType = new TypeToken<Collection<User>>(){}.getType();
        return GSON.fromJson(response.body(), collectionType);
    }

}

