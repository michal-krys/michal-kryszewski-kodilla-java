package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    final List<ForumUser> theUsersList = new ArrayList<>();

    public Forum() {
        theUsersList.add(new ForumUser(101, "userFirst", 'M', LocalDate.of(2010, 2, 10), 0));
        theUsersList.add(new ForumUser(102, "forumUser20", 'M', LocalDate.of(2012, 11, 27), 3));
        theUsersList.add(new ForumUser(103, "jollyUser", 'F', LocalDate.of(1998, 5, 24), 1));
        theUsersList.add(new ForumUser(104, "90user8", 'M', LocalDate.of(2000, 4, 8), 2));
        theUsersList.add(new ForumUser(105, "userFirstOfLasts", 'F', LocalDate.of(1995, 3, 30), 1));
        theUsersList.add(new ForumUser(106, "techUser", 'F', LocalDate.of(1988, 10, 20), 2));
        theUsersList.add(new ForumUser(107, "NewUser", 'M', LocalDate.of(1992, 3, 4), 5));
        theUsersList.add(new ForumUser(108, "userFi", 'F', LocalDate.of(2001, 12, 21), 0));
    }

    public List<ForumUser> getUsersList() {
        return new ArrayList<>(theUsersList);
    }
}
