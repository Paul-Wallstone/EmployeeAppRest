package com.mastery.java.task;

public enum PagesPathEnum {
    HOME_PAGE("home");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
