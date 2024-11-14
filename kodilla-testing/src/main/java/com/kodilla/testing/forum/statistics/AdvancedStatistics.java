package com.kodilla.testing.forum.statistics;

public class AdvancedStatistics {

    private int userCount;
    private int postCount;
    private int commentCount;
    private double meanPostsPerUser;
    private double meanCommentsPerUser;
    private double meanCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        userCount = statistics.userNames().size();
        postCount = statistics.postsCount();
        commentCount = statistics.commentsCount();
        meanPostsPerUser = userCount > 0 ? (double) postCount / userCount : 0;
        meanCommentsPerUser = userCount > 0 ? (double) commentCount / userCount : 0;
        meanCommentsPerPost = postCount > 0 ? (double) commentCount / postCount : 0;
    }

    public void showStatistics() {
        System.out.println("User Count: " + userCount);
        System.out.println("Post Count: " + postCount);
        System.out.println("Comments Count: " + commentCount);
        System.out.println("Mean Posts Per User: " + meanPostsPerUser);
        System.out.println("Mean Comments Per User: " + meanCommentsPerUser);
        System.out.println("Mean Comments Per Post: " + meanCommentsPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getMeanPostsPerUser() {
        return meanPostsPerUser;
    }

    public double getMeanCommentsPerUser() {
        return meanCommentsPerUser;
    }

    public double getMeanCommentsPerPost() {
        return meanCommentsPerPost;
    }
}
