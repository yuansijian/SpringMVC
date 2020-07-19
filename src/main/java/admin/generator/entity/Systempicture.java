package admin.generator.entity;

public class Systempicture
{
    private Integer id;

    private String pictureurl;

    private Integer isDelete;

    private String picturename;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPictureurl()
    {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl)
    {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getPicturename()
    {
        return picturename;
    }

    public void setPicturename(String picturename)
    {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    @Override
    public String toString()
    {
        return "Systempicture{" + "id=" + id + ", pictureurl='" + pictureurl + '\'' + ", isDelete=" + isDelete + ", picturename='" + picturename + '\'' + '}';
    }
}