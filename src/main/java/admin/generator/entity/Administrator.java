package admin.generator.entity;

public class Administrator {
    private Integer id;

    private String username;

    private String password;

    private Integer isDelete;

    private Integer authority;

    private String createtime;

    private String logintime;

    private Integer loginnumber;

    private String endtime;

    private String updatepasswordtime;

    private String updatetime;

    private String deleteTime;

    private String email;

    private String phone;

    private String imageurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime == null ? null : logintime.trim();
    }

    public Integer getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(Integer loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getUpdatepasswordtime() {
        return updatepasswordtime;
    }

    public void setUpdatepasswordtime(String updatepasswordtime) {
        this.updatepasswordtime = updatepasswordtime == null ? null : updatepasswordtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        return "Administrator{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", isDelete=" + isDelete + ", authority=" + authority + ", createtime='" + createtime + '\'' + ", logintime='" + logintime + '\'' + ", loginnumber=" + loginnumber + ", endtime='" + endtime + '\'' + ", updatepasswordtime='" + updatepasswordtime + '\'' + ", updatetime='" + updatetime + '\'' + ", deleteTime='" + deleteTime + '\'' + ", email='" + email + '\'' + ", phone='" + phone + '\'' + ", imageurl='" + imageurl + '\'' + '}';
    }
}