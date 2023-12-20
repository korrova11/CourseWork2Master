package pro.sky.java.course2.CourseWork2Master.service;

import org.springframework.web.server.MethodNotAllowedException;
import pro.sky.java.course2.CourseWork2Master.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer) throws MethodNotAllowedException;

    Question remove(Question question);

    Collection<Question> getAll();

    Question find(String question);

     Question getRandomQuestion();

    int size();
}


