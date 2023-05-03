package module13;

import module13.jsonplaceholder.JsonPlaceholder;
import module13.posts.CommentToPost;
import module13.todos.TaskToDo;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        JsonPlaceholder jsonPlaceholder = new JsonPlaceholder();
        CommentToPost commentToPost = new CommentToPost();
        TaskToDo taskToDo = new TaskToDo();

        System.out.println("----- CREATE USER -----");
        jsonPlaceholder.createUser();
        System.out.println("----- UPDATE USER -----");
        jsonPlaceholder.updateUser(10);
        System.out.println("----- DELETE USER -----");
        jsonPlaceholder.deleteUser(8);
        System.out.println("----- GET ALL USERS LIST -----");
        jsonPlaceholder.getAllUsers();
        System.out.println("----- GET USER BY ID -----");
        jsonPlaceholder.getUserById(7);
        System.out.println("----- GET USER BY USER NAME -----");
        jsonPlaceholder.getUserByUserName("Bret");

        System.out.println("----- CREATE JSON WITH COMMENTS FOT LAST POST -----");
        commentToPost.createJsonWithAllCommentsFromLastPostByUserId(5);
        System.out.println("----- CREATE JSON WITH OPEN TASKS -----");
        taskToDo.createJsonWithOpenTasks(5);
    }
}
