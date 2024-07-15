package com.banggood.checklist.dto;

import com.banggood.checklist.domain.Question;

public record QuestionResponse(
        Long questionId,
        String questionTitle,
        String questionSubTitle) {

    public static QuestionResponse from(Question question) {
        return new QuestionResponse(question.getId(), question.getTitle(), question.getSubtitle());
    }
}
