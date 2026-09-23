package com.example.restapi.domain;

public class User {

    private String userid;
    private String passwd;
    private String name;
    private String email;
    private String createdAt;

    public User() {
    }

    public User(String userid, String passwd, String name, String email, String createdAt) {
        this.userid = userid;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public String getUserid() {
        return userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("userid='").append(userid).append('\'');
        sb.append(", passwd='").append(passwd).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", createdAt='").append(createdAt).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
