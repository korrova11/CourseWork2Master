package pro.sky.java.course2.CourseWork2Master;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.CourseWork2Master.exception.QuestionNotFound;
import pro.sky.java.course2.CourseWork2Master.model.Question;
import pro.sky.java.course2.CourseWork2Master.reposytory.JavaQuestionRepository;
import pro.sky.java.course2.CourseWork2Master.service.JavaQuestionService;
import pro.sky.java.course2.CourseWork2Master.service.MathQuestionService;
import pro.sky.java.course2.CourseWork2Master.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class QuestionServiceTest {
    private final JavaQuestionRepository javaRepository = mock(JavaQuestionRepository.class);
   // private final MathQuestionRepository mathRepository = mock(MathQuestionRepository.class);
    private QuestionService outJ;
  //  private QuestionService outM;

    @BeforeEach
    public void initOut() {
        outJ = new JavaQuestionService(javaRepository);
      //  outM = new MathQuestionService(mathRepository);

    }


    private final String QUESTION1 = "Вопрос1";
    private final String QUESTION2 = "Вопрос2";
    private final String ANSWER1 = "Ответ1";
    private final String ANSWER2 = "Ответ2";
    private final Question questionJ = new Question(QUESTION1, ANSWER1);
    private final Question questionM = new Question(QUESTION2, ANSWER2);
    private final List QUESTIONS = new ArrayList<>(List.of(questionJ, questionM));

    @Test
    public void addTest() {
        when(javaRepository.add(QUESTION1, ANSWER1)).thenReturn(questionJ);
               assertEquals(questionJ, outJ.add(QUESTION1, ANSWER1));
        verify(javaRepository, times(1)).add(QUESTION1, ANSWER1);
    }

    @Test
    public void addWhenThrowTest() {
        when(javaRepository.add(any(), any())).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> outJ.add(QUESTION1, ANSWER1));
    }

    @Test
    public void removeTest() {
        when(javaRepository.remove(questionJ)).thenReturn(questionJ);

        assertEquals(questionJ, outJ.remove(questionJ));
        verify(javaRepository, times(1)).remove(questionJ);

    }

    @Test
    public void removeWhenThrowTest() {
        when(javaRepository.remove(any())).thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class, () -> outJ.remove(questionJ));
    }

    @Test
    public void getAllTestJava() {
        when(javaRepository.getAll()).thenReturn(QUESTIONS);
        assertIterableEquals(QUESTIONS, outJ.getAll());
    }


    @Test
    public void findTest() {
        when(javaRepository.find(QUESTION1)).thenReturn(questionJ);

        assertEquals(questionJ, outJ.find(QUESTION1));
        verify(javaRepository, times(1)).find(QUESTION1);
    }

    @Test
    public void findWhenThrowTest() {
        when(javaRepository.find(any())).thenThrow(QuestionNotFound.class);
        assertThrows(QuestionNotFound.class, () -> outJ.find(QUESTION1));
    }
}

