package com.banggood.checklist.domain;

public class QuestionAnswer {

    private Question question;
    private Integer answer;

    public QuestionAnswer(Question question, Integer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public Integer getAnswer() {
        return answer;
    }
}
