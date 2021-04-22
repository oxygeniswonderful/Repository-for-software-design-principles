package Instagram.queries;

public class SelectLike<LikeCommand> implements Query<LikeCommand> {
    public int likeId;

    public SelectLike(int likeId) {
        this.likeId = likeId;
    }
}
