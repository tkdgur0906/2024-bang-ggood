package com.banggood.checklist.domain;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    static List<Question> questions = new ArrayList<>();

    static {
        questions.add(new Question(1L, Categories.getCategory(1L), "방 안에 물이 새거나 곰팡이가 핀 곳은 없나요? ", "천장, 벽면, 가구 뒤, 장판을 확인하세요. "));
        questions.add(new Question(2L, Categories.getCategory(1L), "벌레가 나온 흔적은 없나요?", "벌레 퇴치약이 부착되어있는지, 싱크대 하부장 경첩에 배설물이 있는지 확인하세요."));
        questions.add(new Question(3L, Categories.getCategory(2L), "수압 및 배수가 괜찮은가요?", "싱크대와 화장실에서 동시에 물을 틀어보세요."));
        questions.add(new Question(4L, Categories.getCategory(2L), "온수가 잘 나오나요?", null));
        questions.add(new Question(5L, Categories.getCategory(2L), "파손된 시설 (창문 / 방충망 / 벽)이 있지 않나요?", null));
        questions.add(new Question(6L, Categories.getCategory(3L), "지하철역과 버스 정류장이 가까운 곳에 있나요?", null));
        questions.add(new Question(7L, Categories.getCategory(4L), "환기가 잘 되는 구조인가요?", "창문의 크기와 방향을 확인하세요."));
        questions.add(new Question(8L, Categories.getCategory(4L), "방음이 잘 되나요?", "벽을 두드려서 가벽이 아닌지 확인하세요."));
        questions.add(new Question(9L, Categories.getCategory(5L), "출입구와 복도에 CCTV가 설치되어 있나요?", null));
        questions.add(new Question(10L,Categories.getCategory(5L),  "자취방의 보안 시설이 잘 갖추어져 있나요? (도어락, 창문 잠금장치 등)", null));
        questions.add(new Question(11L,Categories.getCategory(6L),  "보증금/전월세 비용이 합리적인가요?", "관리비도 포함하여 고려하세요."));

    }

    public static Question getQuestion(Long id) {
        return questions.get(id.intValue() - 1);
    }

    public static List<Question> findQuestionsByCategory(Category category) {
        return questions.stream()
                .filter(question -> question.getCategory().equals(category)).toList();
    }

    public static List<Question> findAll() {
        return questions;
    }
}
