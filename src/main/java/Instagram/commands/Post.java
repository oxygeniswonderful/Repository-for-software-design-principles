package Instagram.commands;

import java.util.ArrayList;
import java.util.Collection;

public class Post extends Command {
    public int postId;
    public Image image;
    public Collection<Integer> commentIds;
    public Collection<Integer> likedProfiles;

    public Post(int postId, Image image) {
        this.postId = postId;
        this.image = image;
        commentIds = new ArrayList<Integer>();
        likedProfiles = new ArrayList<Integer>();
    }

}
