package Instagram.queries.;



public class CreatePost<Integer> implements Query<Integer> {
    public Integer postId;

    public  CreatePost(Integer postId) {
        this.postId = postId;
    }
}
