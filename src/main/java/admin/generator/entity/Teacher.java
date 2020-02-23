package admin.generator.entity;

public class Teacher {
    private Integer id;

    private String teaname;

    private String username;

    private String password;

    private String registeredtime;

    private Integer loginnumber;

    private String logintime;

    private String endtime;

    private Integer sex;

    private String deleteTime;

    private Integer isDelete;

    private String grade;

    private String updatepasswordtime;

    private String classes;

    private String imageurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRegisteredtime() {
        return registeredtime;
    }

    public void setRegisteredtime(String registeredtime) {
        this.registeredtime = registeredtime == null ? null : registeredtime.trim();
    }

    public Integer getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(Integer loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime == null ? null : logintime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getUpdatepasswordtime() {
        return updatepasswordtime;
    }

    public void setUpdatepasswordtime(String updatepasswordtime) {
        this.updatepasswordtime = updatepasswordtime == null ? null : updatepasswordtime.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    @Override
    public String toString()
    {
        return "Teacher{" + "id=" + id + ", teaname='" + teaname + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", registeredtime='" + registeredtime + '\'' + ", loginnumber=" + loginnumber + ", logintime='" + logintime + '\'' + ", endtime='" + endtime + '\'' + ", sex=" + sex + ", deleteTime='" + deleteTime + '\'' + ", isDelete=" + isDelete + ", grade='" + grade + '\'' + ", updatepasswordtime='" + updatepasswordtime + '\'' + ", classes='" + classes + '\'' + ", imageurl='" + imageurl + '\'' + '}';
    }
}