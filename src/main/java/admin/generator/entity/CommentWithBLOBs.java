package admin.generator.entity;

public class CommentWithBLOBs extends Comment
{
    private String comment;

    private String commenturl;

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getCommenturl()
    {
        return commenturl;
    }

    public void setCommenturl(String commenturl)
    {
        this.commenturl = commenturl == null ? null : commenturl.trim();
    }
}