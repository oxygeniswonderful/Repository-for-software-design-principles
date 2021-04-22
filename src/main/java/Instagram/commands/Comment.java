package Instagram.commands;

public class Comment extends Command {

    public int commentId;
    public int postId;
    public String commentary;

    public Comment(int commentId, int postId, String commentary) {
        this.commentary = commentary;
        this.commentId = commentId;
        this.postId = postId;
    }
}
