package com.mutou.service;

import com.mutou.model.Student;
import com.mutou.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }


    /**
     * 包含被软删除的部分
     *
     * @param id 对象的ID号
     * @return Student对象
     */
    public Student findOne(int id) {
        return studentRepository.findOne(id);
    }
}
