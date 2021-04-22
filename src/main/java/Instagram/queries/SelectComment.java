package Instagram.queries;

public class SelectComment<Comment> implements Query<Comment> {
    public int commentId;

    public SelectComment(int commentId) {
        this.commentId = commentId;
    }
}
