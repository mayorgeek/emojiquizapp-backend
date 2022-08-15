package com.aiotouch.emojiquizapp.controller;

import com.aiotouch.emojiquizapp.dto.QuestionDTO;
import com.aiotouch.emojiquizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cpanel/questions/")
public class ViewController {

    private final QuestionService questionService;

    @GetMapping
    public String questionsPage(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "Questions";
    }

    @GetMapping("/create")
    public String addQuestionPage(Model model) {
        QuestionDTO question = new QuestionDTO();
        model.addAttribute("question", question);
        return "AddQuestion";
    }


    @GetMapping("/edit/{questionId}")
    public String editQuestionPage(Model model, @PathVariable Long questionId) {
        model.addAttribute("question", questionService.getQuestionById(questionId));
        return "EditQuestion";
    }


    @PostMapping
    public String addQuestion(@ModelAttribute("question") @Valid QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return "redirect:/cpanel/questions/";
    }


    @PostMapping("/{questionId}")
    public String updateQuestion(@PathVariable @NotNull long questionId,
                                                 @ModelAttribute("question") @Valid QuestionDTO oldQuestion) {
        questionService.updateQuestion(questionId, oldQuestion);
        return "redirect:/cpanel/questions/";
    }


    @GetMapping("/{questionId}")
    public String deleteQuestion(@PathVariable long questionId) {
        questionService.deleteQuestion(questionId);
        return "redirect:/cpanel/questions/";
    }

}
