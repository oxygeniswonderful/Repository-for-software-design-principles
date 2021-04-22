package Instagram.commands;

public class LikeCommand extends Command {

    public int like;
    public int likeId;

    public LikeCommand(int like, int likeId) {
        this.like = like;
        this.likeId = likeId;
    }

}
