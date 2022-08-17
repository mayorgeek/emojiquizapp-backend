package com.aiotouch.emojiquizapp.controller;

import com.aiotouch.emojiquizapp.entity.Question;
import com.aiotouch.emojiquizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/questions/")
@RestController
public class QuestionContoller {

    private final QuestionService questionService;


    /* GET ALL QUESTIONS */
    @GetMapping
    public ResponseEntity<List<Question>> getQuestions() {
        return ResponseEntity.ok()
                .body(questionService.getAllQuestions());
    }

    @GetMapping("/test")
    public String hello() {
        return "Hello Motherfuckkers";
    }

}
