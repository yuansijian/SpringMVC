package admin.generator.entity;

public class CommentParentChild
{
    private Integer id;

    private Integer parentid;

    private String parentname;

    private String creatTime;

    private Integer isDelete;

    private String deleteTime;

    private String updatetime;

    private Integer flag;

    private String username;

    private String pictureurl;

    private Integer up;

    private Integer uid;

    private String content;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getParentid()
    {
        return parentid;
    }

    public void setParentid(Integer parentid)
    {
        this.parentid = parentid;
    }

    public String getParentname()
    {
        return parentname;
    }

    public void setParentname(String parentname)
    {
        this.parentname = parentname == null ? null : parentname.trim();
    }

    public String getCreatTime()
    {
        return creatTime;
    }

    public void setCreatTime(String creatTime)
    {
        this.creatTime = creatTime == null ? null : creatTime.trim();
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

    public String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(String updatetime)
    {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public Integer getFlag()
    {
        return flag;
    }

    public void setFlag(Integer flag)
    {
        this.flag = flag;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }

    public String getPictureurl()
    {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl)
    {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public Integer getUp()
    {
        return up;
    }

    public void setUp(Integer up)
    {
        this.up = up;
    }

    public Integer getUid()
    {
        return uid;
    }

    public void setUid(Integer uid)
    {
        this.uid = uid;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }
}