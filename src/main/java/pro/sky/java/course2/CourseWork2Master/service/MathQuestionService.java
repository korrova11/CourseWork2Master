package pro.sky.java.course2.CourseWork2Master.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;
import pro.sky.java.course2.CourseWork2Master.exception.MethodNotAllowed;
import pro.sky.java.course2.CourseWork2Master.model.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {


    @Override
    public Question add(String question, String answer)  {
        return null;
    }


    @Override
    public Question remove(Question question) {

        return null;
    }

    @Override
    public Collection<Question> getAll() {

        return null;
    }

    @Override
    public Question find(String question) {
        return null;

    }

    @Override
    public  Question getRandomQuestion() {
       Random random = new Random();
        int i = random.nextInt(25);
        int j= random.nextInt(25);

        return new Question("дайте результат вычисления: "+ i+ "умножить на " +j,
                "результат равен "+ i*j);

    }



    @Override
    public int size() {
        return 0;
    }
}

