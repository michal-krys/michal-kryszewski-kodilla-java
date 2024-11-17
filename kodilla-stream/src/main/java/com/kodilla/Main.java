package com.kodilla;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.world.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Forum theForum = new Forum();
        Map<Integer, ForumUser> theFilteredUsers = theForum.getUsersList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getUserAge() >= 20)
                .filter(user -> user.getPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        System.out.println("# elements: " + theFilteredUsers.size());
        theFilteredUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


    }
}