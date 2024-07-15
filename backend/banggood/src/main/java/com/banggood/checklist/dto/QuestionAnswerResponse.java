package com.banggood.checklist.dto;

import com.banggood.checklist.domain.QuestionAnswer;

public record QuestionAnswerResponse(
        Long questionId,
        String questionTitle,
        String questionSubtitle,
        Integer answer
) {

    public static QuestionAnswerResponse from(QuestionAnswer questionAnswer) {
        return new QuestionAnswerResponse(questionAnswer.getQuestion().getId(),
                questionAnswer.getQuestion().getTitle(),
                questionAnswer.getQuestion().getSubtitle(),
                questionAnswer.getAnswer());
    }
}
