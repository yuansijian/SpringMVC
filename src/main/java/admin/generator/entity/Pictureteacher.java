package admin.generator.entity;

public class Pictureteacher
{
    private Integer id;

    private String pname;

    private String pictureurl;

    private String author;

    private Integer isDelete;

    private String deletetime;

    private String createtime;

    private String updatetime;

    private String world;

    private String updater;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPictureurl()
    {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl)
    {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author == null ? null : author.trim();
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getDeletetime()
    {
        return deletetime;
    }

    public void setDeletetime(String deletetime)
    {
        this.deletetime = deletetime == null ? null : deletetime.trim();
    }

    public String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(String createtime)
    {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(String updatetime)
    {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getWorld()
    {
        return world;
    }

    public void setWorld(String world)
    {
        this.world = world == null ? null : world.trim();
    }

    public String getUpdater()
    {
        return updater;
    }

    public void setUpdater(String updater)
    {
        this.updater = updater == null ? null : updater.trim();
    }
}