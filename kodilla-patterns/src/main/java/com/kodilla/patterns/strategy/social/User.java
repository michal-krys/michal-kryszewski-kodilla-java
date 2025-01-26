package com.kodilla.patterns.strategy.social;

public sealed class User
        permits Millenials, YGeneration, ZGeneration{

    private final String name;
    protected SocialPublisher socialPublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String publish() {
        return socialPublisher.share();
    }
}
