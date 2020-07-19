package admin.generator.entity;

public class Student
{
    private Integer id;

    private String stuname;

    private String stunumber;

    private String stuphone;

    private String stumail;

    private String password;

    private String username;

    private String lastname;

    private String registeredtime;

    private Integer loginnumber;

    private String deleteTime;

    private String logintime;

    private String endtime;

    private Integer isDelete;

    private String grade;

    private Integer sex;

    private String updatetime;

    private String class1;

    private String updatepasswordtime;

    private String imageurl;

    public void setStunumber(String stunumber)
    {
        this.stunumber = stunumber;
    }

    public String getStunumber()
    {
        return stunumber;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getStuname()
    {
        return stuname;
    }

    public void setStuname(String stuname)
    {
        this.stuname = stuname == null ? null : stuname.trim();
    }


    public String getStuphone()
    {
        return stuphone;
    }

    public void setStuphone(String stuphone)
    {
        this.stuphone = stuphone == null ? null : stuphone.trim();
    }

    public String getStumail()
    {
        return stumail;
    }

    public void setStumail(String stumail)
    {
        this.stumail = stumail == null ? null : stumail.trim();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getRegisteredtime()
    {
        return registeredtime;
    }

    public void setRegisteredtime(String registeredtime)
    {
        this.registeredtime = registeredtime == null ? null : registeredtime.trim();
    }

    public Integer getLoginnumber()
    {
        return loginnumber;
    }

    public void setLoginnumber(Integer loginnumber)
    {
        this.loginnumber = loginnumber;
    }

    public String getDeleteTime()
    {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime)
    {
        this.deleteTime = deleteTime == null ? null : deleteTime.trim();
    }

    public String getLogintime()
    {
        return logintime;
    }

    public void setLogintime(String logintime)
    {
        this.logintime = logintime == null ? null : logintime.trim();
    }

    public String getEndtime()
    {
        return endtime;
    }

    public void setEndtime(String endtime)
    {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public String getUpdatetime()
    {
        return updatetime;
    }

    public void setUpdatetime(String updatetime)
    {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getClass1()
    {
        return class1;
    }

    public void setClass1(String class1)
    {
        this.class1 = class1 == null ? null : class1.trim();
    }

    public String getUpdatepasswordtime()
    {
        return updatepasswordtime;
    }

    public void setUpdatepasswordtime(String updatepasswordtime)
    {
        this.updatepasswordtime = updatepasswordtime == null ? null : updatepasswordtime.trim();
    }

    public String getImageurl()
    {
        return imageurl;
    }

    public void setImageurl(String imageurl)
    {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    @Override
    public String toString()
    {
        return "Student{" + "id=" + id + ", stuname='" + stuname + '\'' + ", stunumber=" + stunumber + ", stuphone='" + stuphone + '\'' + ", stumail='" + stumail + '\'' + ", password='" + password + '\'' + ", username='" + username + '\'' + ", lastname='" + lastname + '\'' + ", registeredtime='" + registeredtime + '\'' + ", loginnumber=" + loginnumber + ", deleteTime='" + deleteTime + '\'' + ", logintime='" + logintime + '\'' + ", endtime='" + endtime + '\'' + ", isDelete=" + isDelete + ", grade='" + grade + '\'' + ", sex=" + sex + ", updatetime='" + updatetime + '\'' + ", class1='" + class1 + '\'' + ", updatepasswordtime='" + updatepasswordtime + '\'' + ", imageurl='" + imageurl + '\'' + '}';
    }
}