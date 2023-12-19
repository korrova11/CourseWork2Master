package pro.sky.java.course2.CourseWork2Master.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.CourseWork2Master.exception.MethodNotAllowed;
import pro.sky.java.course2.CourseWork2Master.model.Question;
import pro.sky.java.course2.CourseWork2Master.service.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {


    @Qualifier("mathQuestionService")
    private final MathQuestionService mathQuestionService;


    public MathQuestionController(MathQuestionService question) {

        this.mathQuestionService = question;
    }


    @GetMapping("/add")

    public Question add(@RequestParam String question, @RequestParam String answer) {
        throw new MethodNotAllowed();


    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {

        throw new MethodNotAllowed();
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        throw new MethodNotAllowed();

    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        throw new MethodNotAllowed();
    }

}
