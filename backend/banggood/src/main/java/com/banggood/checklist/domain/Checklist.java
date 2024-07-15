package com.banggood.checklist.domain;

import java.util.List;

public class Checklist {

    private Long id;
    private List<QuestionAnswer> questionAnswers;

    public Checklist(Long id, List<QuestionAnswer> questionAnswers) {
        this.id = id;
        this.questionAnswers = questionAnswers;
    }

    public Long getId() {
        return id;
    }

    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public List<QuestionAnswer> findByCategory(Category category) {
        return questionAnswers.stream()
                .filter(questionAnswer -> questionAnswer.getQuestion().getCategory().equals(category))
                .toList();
    }
}
