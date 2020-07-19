package admin.generator.entity;

import java.util.Date;

public class Replygood
{
    private Integer id;

    private Integer uid;

    private Integer up;

    private Integer cid;

    private Integer isDelete;

    private Date goodtime;

    private Date updatetime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUid()
    {
        return uid;
    }

    public void setUid(Integer uid)
    {
        this.uid = uid;
    }

    public Integer getUp()
    {
        return up;
    }

    public void setUp(Integer up)
    {
        this.up = up;
    }

    public Integer getCid()
    {
        return cid;
    }

    public void setCid(Integer cid)
    {
        this.cid = cid;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Date getGoodtime()
    {
        return goodtime;
    }

    public void setGoodtime(Date goodtime)
    {
        this.goodtime = goodtime;
    }

    public Date getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime)
    {
        this.updatetime = updatetime;
    }
}