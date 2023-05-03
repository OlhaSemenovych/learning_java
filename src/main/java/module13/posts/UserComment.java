package module13.posts;

public class UserComment {

    String postId;
    int id;
    String name;
    String email;
    String body;

    public UserComment(String postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "postId='" + postId + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}
