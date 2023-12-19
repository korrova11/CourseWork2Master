package pro.sky.java.course2.CourseWork2Master.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.CourseWork2Master.exception.FullSet;
import pro.sky.java.course2.CourseWork2Master.model.Question;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {



    private final List<QuestionService> list;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.list = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }


    @Override
    public Set<Question> getQuestion(int amount) {
        int halfAmount = amount - amount / 2;

        Set<Question> questionsJava = new HashSet<>();
        Set<Question> questionsMath = new HashSet<>();
        while (list.size() < halfAmount) {

           questionsJava.add(list.get(0).getRandomQuestion());
        }
        while (list.size() < amount) {
            questionsMath.add(list.get(1).getRandomQuestion());
        }
        questionsMath.addAll(questionsJava);
        return questionsMath;
    }
}

