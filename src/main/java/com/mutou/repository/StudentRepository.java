package com.mutou.repository;

import com.mutou.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
