package admin.generator.entity;

public class BaseconfigWithBLOBs extends Baseconfig
{
    private String description;

    private String copyright;

    private String record;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description == null ? null : description.trim();
    }

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getRecord()
    {
        return record;
    }

    public void setRecord(String record)
    {
        this.record = record == null ? null : record.trim();
    }

    @Override
    public String toString()
    {
        return "BaseconfigWithBLOBs{" + "description='" + description + '\'' + ", copyright='" + copyright + '\'' + ", record='" + record + '\'' + '}';
    }
}