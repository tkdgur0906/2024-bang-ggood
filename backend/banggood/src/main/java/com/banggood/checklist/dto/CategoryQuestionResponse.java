package com.banggood.checklist.dto;

import com.banggood.checklist.domain.Category;
import java.util.List;

public record CategoryQuestionResponse(
        Long categoryId,
        String category,
        List<QuestionResponse> questions){

    public static CategoryQuestionResponse from(Category category, List<QuestionResponse> questions) {
        return new CategoryQuestionResponse(category.getId(), category.getName(), questions);
    }
}
