package admin.generator.entity;

public class Uploadconfig
{
    private Integer id;

    private Integer image;

    private String imageconfig;

    private Integer limit1;

    private String type1;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getImage()
    {
        return image;
    }

    public void setImage(Integer image)
    {
        this.image = image;
    }

    public String getImageconfig()
    {
        return imageconfig;
    }

    public void setImageconfig(String imageconfig)
    {
        this.imageconfig = imageconfig == null ? null : imageconfig.trim();
    }

    public Integer getLimit1()
    {
        return limit1;
    }

    public void setLimit1(Integer limit1)
    {
        this.limit1 = limit1;
    }

    public String getType1()
    {
        return type1;
    }

    public void setType1(String type1)
    {
        this.type1 = type1 == null ? null : type1.trim();
    }
}