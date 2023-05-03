package module13.posts;

import com.google.gson.Gson;
import utils.JsonFileUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class CommentToPost {

    private static final String URL = "https://jsonplaceholder.typicode.com";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public void createJsonWithAllCommentsFromLastPostByUserId(int userId) throws IOException, InterruptedException {
        JsonFileUtils<UserComment> jsonFileUtils = new JsonFileUtils<>();
        String fileName = String.format("user-%s-post-%s-comments.json", userId, getIdOfTheLastPost(userId));
        jsonFileUtils.createJsonWithName(fileName, getAllUserCommentForLastPost(userId));
    }

    public List<UserComment> getAllUserCommentForLastPost(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/posts/" + getIdOfTheLastPost(userId) + "/comments"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        UserComment[] result = GSON.fromJson(response.body(), UserComment[].class);
        return Arrays.asList(result);
    }

    public int getIdOfTheLastPost(int userId) throws IOException, InterruptedException {
        UserPosts[] result = getAllUsersPost(userId);
        return Arrays.stream(result)
                .map(UserPosts::getId)
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public UserPosts[] getAllUsersPost(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/users/" + userId + "/posts"))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), UserPosts[].class);
    }

}

