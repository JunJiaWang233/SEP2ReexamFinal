package sep2.dataBase.entity;

import sep2.dataBase.entity.constraints.Gender;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Gender gender;
    private Date createDate;

    public User() {
    }

    public User(String username, String password, String email, String phone, Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender=" + gender +
                ", createDate=" + createDate +
                '}';
    }
}
