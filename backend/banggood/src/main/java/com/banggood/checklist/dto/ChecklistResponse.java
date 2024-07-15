package com.banggood.checklist.dto;

import com.banggood.checklist.domain.Category;
import java.util.List;

public record ChecklistResponse(
        Long categoryId,
        String category,
        List<QuestionAnswerResponse> questions) {

    public static ChecklistResponse from(Category category, List<QuestionAnswerResponse> questions) {
        return new ChecklistResponse(category.getId(), category.getName(), questions);
    }
}
