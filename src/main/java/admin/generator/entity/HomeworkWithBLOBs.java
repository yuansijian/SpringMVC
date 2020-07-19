package admin.generator.entity;

public class HomeworkWithBLOBs extends Homework
{
    private String fileurl;

    private String comment;

    public String getFileurl()
    {
        return fileurl;
    }

    public void setFileurl(String fileurl)
    {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment == null ? null : comment.trim();
    }
}