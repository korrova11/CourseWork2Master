package pro.sky.java.course2.CourseWork2Master.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.CourseWork2Master.model.Question;
import pro.sky.java.course2.CourseWork2Master.service.JavaQuestionService;
import pro.sky.java.course2.CourseWork2Master.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")

public class JavaController {
    @Qualifier("javaQuestionService")
    private final QuestionService javaQuestionService;
    public JavaController(JavaQuestionService question) {
        this.javaQuestionService = question;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {

        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return javaQuestionService.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return javaQuestionService.find(question);
    }

}

