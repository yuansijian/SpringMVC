package admin.generator.entity;

public class Baseconfig {
    private Integer id;

    private String logopic;

    private String keyword;

    private Integer switch1;

    private String updatetime;

    private String updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogopic() {
        return logopic;
    }

    public void setLogopic(String logopic) {
        this.logopic = logopic == null ? null : logopic.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getSwitch1() {
        return switch1;
    }

    public void setSwitch1(Integer switch1) {
        this.switch1 = switch1;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    @Override
    public String toString()
    {
        return "Baseconfig{" + "id=" + id + ", logopic='" + logopic + '\'' + ", keyword='" + keyword + '\'' + ", switch1=" + switch1 + ", updatetime='" + updatetime + '\'' + ", updater='" + updater + '\'' + '}';
    }
}