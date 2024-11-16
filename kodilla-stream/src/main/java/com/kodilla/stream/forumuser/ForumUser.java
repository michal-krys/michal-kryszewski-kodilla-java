package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;

public final class ForumUser {

    private final int id;
    private final String username;
    private final char sex;
    private final LocalDate birthdate;
    private final int posts;

    public ForumUser(int id, String username, char sex, LocalDate birthdate, int posts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPosts() {
        return posts;
    }

    public int getUserAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User: " + username + " with ID: " + id + " posted: " + posts + " post/s";
    }
}
