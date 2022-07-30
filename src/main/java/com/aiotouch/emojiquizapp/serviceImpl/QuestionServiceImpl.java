package com.aiotouch.emojiquizapp.serviceImpl;

import com.aiotouch.emojiquizapp.entity.Question;
import com.aiotouch.emojiquizapp.exception.QuestionNotFoundException;
import com.aiotouch.emojiquizapp.model.QuestionModel;
import com.aiotouch.emojiquizapp.repository.QuestionRepository;
import com.aiotouch.emojiquizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepo;

    @Override
    public Question createQuestion(QuestionModel question) {
        Question newQuestion = new Question();
        newQuestion.setImagePath(question.getImagePath());
        newQuestion.setOption1(question.getOption1());
        newQuestion.setOption2(question.getOption2());
        newQuestion.setOption3(question.getOption3());
        newQuestion.setAnswer(question.getAnswer());

        return questionRepo.save(newQuestion);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public Question editQuestion(long questionId) {
        return questionRepo.findById(questionId)
                            .orElseThrow(() -> { throw new QuestionNotFoundException("Question does not exist!"); } );
    }

    @Override
    public void updateQuestion(long questionId, Question oldQuestion) {
        Question question = questionRepo.findById(questionId)
                    .orElseThrow(() -> { throw new QuestionNotFoundException("Question does not exist!"); });

        question.setImagePath(oldQuestion.getImagePath());
        question.setOption1(oldQuestion.getOption1());
        question.setOption2(oldQuestion.getOption2());
        question.setOption3(oldQuestion.getOption3());
        question.setAnswer(oldQuestion.getAnswer());

        questionRepo.save(question);
    }

    @Override
    public void deleteQuestion(long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> { throw new QuestionNotFoundException("This question does not exist"); });
        questionRepo.delete(question);
    }
}
