package module13.posts;

import lombok.Getter;

@Getter
public class UserPosts {

    int userId;
    int id;
    String title;
    String body;

    public UserPosts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "UserPosts{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}
