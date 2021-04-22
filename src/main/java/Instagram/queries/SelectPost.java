package Instagram.queries;

public class SelectPost<Post> implements Query<Post> {
    public int postId;

    public SelectPost(int postId) {
        this.postId = postId;
    }
}
