package com.mutou.service;

import com.mutou.model.Grade;
import com.mutou.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }
}
