package pro.sky.java.course2.CourseWork2Master.reposytory;

import pro.sky.java.course2.CourseWork2Master.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question remove(Question question);

    Question find(String question);

    Collection<Question> getAll();
}

