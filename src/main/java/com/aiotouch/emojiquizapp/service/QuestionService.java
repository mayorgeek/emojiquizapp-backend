package com.aiotouch.emojiquizapp.service;

import com.aiotouch.emojiquizapp.entity.Question;
import com.aiotouch.emojiquizapp.model.QuestionModel;

import java.util.List;

public interface QuestionService {

    Question createQuestion(QuestionModel question);

    List<Question> getAllQuestions();

    Question editQuestion(long questionId);

    void updateQuestion(long questionId, Question oldQuestion);

    void deleteQuestion(long id);
}
