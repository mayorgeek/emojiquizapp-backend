package com.aiotouch.emojiquizapp.serviceImpl;

import com.aiotouch.emojiquizapp.dto.QuestionDTO;
import com.aiotouch.emojiquizapp.entity.Question;
import com.aiotouch.emojiquizapp.exception.QuestionNotFoundException;
import com.aiotouch.emojiquizapp.repository.QuestionRepository;
import com.aiotouch.emojiquizapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepo;

    @Override
    public void createQuestion(QuestionDTO question) {
        Question newQuestion = Question.builder()
                .imagePath(question.getImagePath())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .answer(question.getAnswer())
                .build();

        questionRepo.save(newQuestion);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public Question getQuestionById(long questionId) {
        return questionRepo.findById(questionId)
                            .orElseThrow(() -> { throw new QuestionNotFoundException("Question does not exist!"); } );
    }

    @Override
    public void updateQuestion(long questionId, QuestionDTO oldQuestion) {
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
        questionRepo.findById(id)
                .orElseThrow(() -> { throw new QuestionNotFoundException("This question does not exist"); });

        questionRepo.deleteById(id);
    }
}
