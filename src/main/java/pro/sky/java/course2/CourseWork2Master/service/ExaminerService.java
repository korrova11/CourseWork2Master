package pro.sky.java.course2.CourseWork2Master.service;

import pro.sky.java.course2.CourseWork2Master.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);
}
