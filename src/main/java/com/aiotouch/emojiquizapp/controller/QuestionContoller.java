package com.aiotouch.emojiquizapp.controller;

import com.aiotouch.emojiquizapp.entity.Question;
import com.aiotouch.emojiquizapp.model.QuestionModel;
import com.aiotouch.emojiquizapp.serviceImpl.QuestionServiceImpl;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/questions/")
public class QuestionContoller {

    private final QuestionServiceImpl questionService;

    /* CREATE A NEW QUESTION */
    @PostMapping()
    @Transactional
    public ResponseEntity<Question> addQuestion(@RequestBody @Validated QuestionModel questionModel) {
        Question question = questionService.createQuestion(questionModel);

        return new ResponseEntity<Question>(question, HttpStatus.CREATED);
    }


    /* GET ALL QUESTIONS */
    @GetMapping()
    @Transactional
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }


    /* EDIT A QUESTION */
    @PutMapping("/{questionId}")
    @Transactional
    public String updateQuestion(@PathVariable @NotNull long questionId,
                                 @RequestBody @Validated Question oldQuestion) {
        questionService.updateQuestion(questionId, oldQuestion);
        return "Resource edited successfully";
    }


    /* GET A QUESTION */
    @GetMapping("/{questionId}")
    @Transactional
    public ResponseEntity<Question> editQuestion(@PathVariable @NotNull long questionId) {
        return new ResponseEntity<>(questionService.editQuestion(questionId), HttpStatus.OK);
    }

    /* DELETE A QUESTION */
    @DeleteMapping()
    @Transactional
    public String deleteQuestion(@RequestParam long id) {
        questionService.deleteQuestion(id);
        return "Resource deleted successfully";
    }

}
