package com.example.rantsonli.Models;

public class Users {
    String profilepic, mail, password;

    public Users(String profilepic, String mail, String password) {
        this.profilepic = profilepic;
        this.mail = mail;
        this.password = password;
    }
    public Users(){}
    public Users(String mail, String password){
        this.mail = mail;
        this.password = password;
    }
    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
