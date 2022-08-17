package com.aiotouch.emojiquizapp.controller;

import com.aiotouch.emojiquizapp.dto.QuestionDTO;
import com.aiotouch.emojiquizapp.model.AuthRequest;
import com.aiotouch.emojiquizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cpanel/")
public class ViewController {

    private final QuestionService questionService;


    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @PostMapping("/perform_login")
    public String loginAction(@ModelAttribute String username, @ModelAttribute String password) {

        Authentication authenticate = new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return "redirect:/cpanel/questions/";
    }

    @GetMapping("/questions")
    public String questionsPage(Model model) {
        model.addAttribute("questions", questionService.getAllQuestions());
        return "Questions";
    }

    @GetMapping("/questions/create")
    public String addQuestionPage(Model model) {
        QuestionDTO question = new QuestionDTO();
        model.addAttribute("question", question);
        return "AddQuestion";
    }


    @GetMapping("/questions/edit/{questionId}")
    public String editQuestionPage(Model model, @PathVariable Long questionId) {
        model.addAttribute("question", questionService.getQuestionById(questionId));
        return "EditQuestion";
    }


    @PostMapping("/questions")
    public String addQuestion(@ModelAttribute("question") @Valid QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return "redirect:/cpanel/questions/";
    }


    @PostMapping("/questions/{questionId}")
    public String updateQuestion(@PathVariable @NotNull long questionId,
                                                 @ModelAttribute("question") @Valid QuestionDTO oldQuestion) {
        questionService.updateQuestion(questionId, oldQuestion);
        return "redirect:/cpanel/questions/";
    }


    @GetMapping("/questions/{questionId}")
    public String deleteQuestion(@PathVariable long questionId) {
        questionService.deleteQuestion(questionId);
        return "redirect:/cpanel/questions/";
    }

}
