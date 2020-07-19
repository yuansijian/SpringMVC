package admin.generator.entity;

public class Short1
{
    private Integer id;

    private String title;

    private Integer isDelete;

    private String deleteTime;

    private String questioner;

    private String createtime;

    private String updatetime;

    private String updater;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getDeleteTime()
    {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime)
    {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getQuestioner()
    {
        return questioner;
    }

    public void setQuestioner(String questioner)
    {
        this.questioner = questioner == null ? null : questioner.trim();
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

    public String getUpdater()
    {
        return updater;
    }

    public void setUpdater(String updater)
    {
        this.updater = updater == null ? null : updater.trim();
    }
}