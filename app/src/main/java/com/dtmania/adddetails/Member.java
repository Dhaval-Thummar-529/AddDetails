package com.dtmania.adddetails;

public class Member {
    private String Name;
    private String Email;
    private String Profession;

    public Member() {
    }

    public Member(String name, String email, String profession) {
        Name = name;
        Email = email;
        Profession = profession;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }
}
