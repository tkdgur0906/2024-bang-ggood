package com.banggood.checklist.domain;

import java.util.List;

public class Categories {

    static List<Category> categories = List.of(
            new Category(1L, "청결도"),
            new Category(2L, "내부시설"),
            new Category(3L, "생활시설"),
            new Category(4L, "환경"),
            new Category(5L, "보안"),
            new Category(6L, "예산")
    );

    public static Category getCategory(Long id) {
        return categories.get(id.intValue() - 1);
    }

    public static List<Category> findCategories() {
        return categories;
    }
}
