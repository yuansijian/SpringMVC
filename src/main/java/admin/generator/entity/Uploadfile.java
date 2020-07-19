package admin.generator.entity;

public class Uploadfile
{
    private Integer id;

    private String filename;

    private Integer filesize;

    private String fileurl;

    private Integer isDelete;

    private String uploadtime;

    private String deletetime;

    private String author;

    private String description;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFilesize()
    {
        return filesize;
    }

    public void setFilesize(Integer filesize)
    {
        this.filesize = filesize;
    }

    public String getFileurl()
    {
        return fileurl;
    }

    public void setFileurl(String fileurl)
    {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getUploadtime()
    {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime)
    {
        this.uploadtime = uploadtime == null ? null : uploadtime.trim();
    }

    public String getDeletetime()
    {
        return deletetime;
    }

    public void setDeletetime(String deletetime)
    {
        this.deletetime = deletetime == null ? null : deletetime.trim();
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author == null ? null : author.trim();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description == null ? null : description.trim();
    }
}