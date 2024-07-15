package com.banggood.checklist.controller;

import com.banggood.checklist.domain.Categories;
import com.banggood.checklist.domain.Category;
import com.banggood.checklist.domain.Checklist;
import com.banggood.checklist.domain.Question;
import com.banggood.checklist.domain.QuestionAnswer;
import com.banggood.checklist.domain.Questions;
import com.banggood.checklist.dto.CategoryQuestionResponse;
import com.banggood.checklist.dto.ChecklistRequest;
import com.banggood.checklist.dto.ChecklistPostResponse;
import com.banggood.checklist.dto.ChecklistResponse;
import com.banggood.checklist.dto.QuestionAnswerResponse;
import com.banggood.checklist.dto.QuestionResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChecklistController {

    static List<Checklist> checklists = new ArrayList<>();
    static AtomicLong checklistId = new AtomicLong(1L);

    @PostMapping("/checklist")
    public ResponseEntity<ChecklistPostResponse> createChecklist(@RequestBody List<ChecklistRequest> requests) {
        List<QuestionAnswer> questionAnswers = new ArrayList<>();

        for (Question question : Questions.findAll()) {
            Integer answer = null;
            Optional<ChecklistRequest> createRequest = requests.stream()
                    .filter(request -> request.questionId().equals(question.getId()))
                    .findFirst();

            if (createRequest.isPresent()) {
                answer = createRequest.get().answer();
            }

            questionAnswers.add(new QuestionAnswer(question, answer));
        }

        Long id = checklistId.getAndIncrement();
        checklists.add(new Checklist(id, questionAnswers));

        return ResponseEntity.ok(new ChecklistPostResponse(id));
    }

    @GetMapping("/checklist/question")
    public ResponseEntity<List<CategoryQuestionResponse>> readChecklist() {
        List<CategoryQuestionResponse> categoryQuestionResponses = new ArrayList<>();

        for (Category category : Categories.findCategories()) {
            List<QuestionResponse> responses = Questions.findQuestionsByCategory(category)
                    .stream()
                    .map(QuestionResponse::from)
                    .toList();

            categoryQuestionResponses.add(CategoryQuestionResponse.from(category, responses));
        }

        return ResponseEntity.ok(categoryQuestionResponses);
    }

    @GetMapping("/checklist/{id}")
    public ResponseEntity<List<ChecklistResponse>> readChecklist(@PathVariable Long id) {

        List<ChecklistResponse> checklistResponses = new ArrayList<>();
        Checklist checklist = checklists.get((int) (id - 1));

        for (Category category : Categories.findCategories()) {
            List<QuestionAnswerResponse> questionAnswers = checklist.findByCategory(category)
                            .stream().map(QuestionAnswerResponse::from).toList();

            checklistResponses.add(ChecklistResponse.from(category, questionAnswers));
        }

        return ResponseEntity.ok(checklistResponses);
    }
}
