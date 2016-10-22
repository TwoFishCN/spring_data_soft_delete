package com.mutou.service;

import com.mutou.model.Grade;
import com.mutou.model.Student;
import com.mutou.model.Teacher;
import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private GradeService gradeService;

    private int studentId;
    private int teacherId;
    private int gradeId;

    @BeforeTransaction
    @Before
    public void someDataInit() {
        Timestamp now = new Timestamp(0);

        List<Student> students = new ArrayStack<>();
        Student student = new Student();
        student.setBirthday(now);
        student.setDeletedAt(now);
        student.setName("student");
        student = studentService.save(student);
        students.add(student);

        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        teacher.setBirthday(now);
        teacher.setDeletedAt(now);
        teacher.setStudents(students);
        teacher = teacherService.save(teacher);

        Grade grade = new Grade();
        grade.setDeletedAt(now);
        grade.setNum(5);
        grade.setStudents(students);
        grade = gradeService.save(grade);

        studentId = student.getId();
        teacherId = teacher.getId();
        gradeId = grade.getId();
    }

    @Test
    @Transactional
    public void delete() throws Exception {
        deleteOne();
        Teacher teacher = teacherService.findOne(teacherId);
        Student student = teacher.getStudents().get(0);
        student.getDeletedAt().after(new Timestamp(0));
    }

    @Transactional
    private void deleteOne() {
        Student student = studentService.findOne(studentId);
        studentService.delete(student.getId());
    }
}