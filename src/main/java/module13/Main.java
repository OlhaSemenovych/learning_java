package module13;

import module13.jsonplaceholder.JsonPlaceholder;
import module13.posts.UserComment;
import module13.todos.TaskToDo;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        JsonPlaceholder jsonPlaceholder = new JsonPlaceholder();
        UserComment userComment = new UserComment();
        TaskToDo taskToDo = new TaskToDo();

        System.out.println("----- CREATE USER -----");
        System.out.println(jsonPlaceholder.createUser());
        System.out.println("----- UPDATE USER -----");
        System.out.println(jsonPlaceholder.updateUser(10));
        System.out.println("----- DELETE USER -----");
        System.out.println(jsonPlaceholder.deleteUser(8));
        System.out.println("----- GET ALL USERS LIST -----");
        System.out.println(jsonPlaceholder.getAllUsers());
        System.out.println("----- GET USER BY ID -----");
        System.out.println(jsonPlaceholder.getUserById(7));
        System.out.println("----- GET USER BY USER NAME -----");
        System.out.println(jsonPlaceholder.getUserByUserName("Bret"));
        jsonPlaceholder.getUserByUserName("Bret");

        System.out.println("----- CREATE JSON WITH COMMENTS FOT LAST POST -----");
        userComment.createJsonWithAllCommentsFromLastPostByUserId(5);
        System.out.println("----- CREATE JSON WITH OPEN TASKS -----");
        taskToDo.createJsonWithOpenTasks(5);
    }
}
