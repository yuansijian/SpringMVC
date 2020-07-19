package admin.generator.entity;

public class Video
{
    private Integer id;

    private Integer isDelete;

    private String uploadtime;

    private String author;

    private String deleteTime;

    private String updatetime;

    private String updater;

    private String vsizes;

    private String vname;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author == null ? null : author.trim();
    }

    public String getDeleteTime()
    {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime)
    {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(String updatetime)
    {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUpdater()
    {
        return updater;
    }

    public void setUpdater(String updater)
    {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getVsizes()
    {
        return vsizes;
    }

    public void setVsizes(String vsizes)
    {
        this.vsizes = vsizes == null ? null : vsizes.trim();
    }

    public String getVname()
    {
        return vname;
    }

    public void setVname(String vname)
    {
        this.vname = vname == null ? null : vname.trim();
    }
}