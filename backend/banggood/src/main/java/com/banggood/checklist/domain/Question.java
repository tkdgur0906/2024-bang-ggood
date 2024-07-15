package com.banggood.checklist.domain;

public class Question {

    private final Long id;
    private final Category category;
    private final String title;
    private final String subtitle;

    public Question(Long id, Category category, String title, String subtitle) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.subtitle = subtitle;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Category getCategory() {
        return category;
    }
}
