package com.aiotouch.emojiquizapp.service;

import com.aiotouch.emojiquizapp.dto.QuestionDTO;
import com.aiotouch.emojiquizapp.entity.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(QuestionDTO question);

    List<Question> getAllQuestions();

    Question getQuestionById(long questionId);

    void updateQuestion(long questionId, QuestionDTO oldQuestion);

    void deleteQuestion(long id);
}
