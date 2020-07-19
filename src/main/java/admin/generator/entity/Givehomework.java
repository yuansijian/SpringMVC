package admin.generator.entity;

public class Givehomework
{
    private Integer id;

    private String author;

    private String createTime;

    private String deleteTime;

    private Integer idDelete;

    private String updatetime;

    private String updater;

    private String endtime;

    private String starttime;

    private String title;

    private String description;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author == null ? null : author.trim();
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getDeleteTime()
    {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime)
    {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public Integer getIdDelete()
    {
        return idDelete;
    }

    public void setIdDelete(Integer idDelete)
    {
        this.idDelete = idDelete;
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

    public String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(String endtime)
    {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getStarttime()
    {
        return starttime;
    }

    public void setStarttime(String starttime)
    {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString()
    {
        return "Givehomework{" + "id=" + id + ", author='" + author + '\'' + ", createTime='" + createTime + '\'' + ", deleteTime='" + deleteTime + '\'' + ", idDelete=" + idDelete + ", updatetime='" + updatetime + '\'' + ", updater='" + updater + '\'' + ", endtime='" + endtime + '\'' + ", starttime='" + starttime + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + '}';
    }
}