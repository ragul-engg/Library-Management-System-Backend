package io.library.libmgmtsys.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    // @Column(nullable = false)
    // private String roles;

    public User(Long userId, String userName, String mobileNumber, String email, String password, String roles) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        // this.roles = roles;
    }

    // public String getRoles() {
    // return roles;
    // }

    // public void setRoles(String roles) {
    // this.roles = roles;
    // }

    public User() {

    }

    // @Override
    // public String toString() {
    // return "User{" +
    // "userId=" + userId +
    // ", userName='" + userName + '\'' +
    // ", mobileNumber='" + mobileNumber + '\'' +
    // ", email='" + email + '\'' +
    // ", password='" + password + '\'' +
    // ", roles='" + roles + '\'' +
    // '}';
    // }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber + ", email="
                + email + ", password=" + password + "]";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}