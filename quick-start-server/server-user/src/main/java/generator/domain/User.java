package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
public class User implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Integer deleteflag;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     */
    public Integer getDeleteflag() {
        return deleteflag;
    }

    /**
     * 
     */
    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }
}