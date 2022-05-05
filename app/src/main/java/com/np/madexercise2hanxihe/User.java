package com.np.madexercise2hanxihe;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String name, String desc, Integer id, Boolean followed) {
        this.name = name;
        this.description = desc;
        this.id = id;
        this.followed = followed;
    }
}
