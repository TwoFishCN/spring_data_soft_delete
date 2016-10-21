package com.mutou.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
@Entity
@Data
@SQLDelete(sql = "UPDATE student SET deleted_at = now() where id = ?")
@Where(clause = "deleted_at < '1970-01-02'")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private Timestamp birthday;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @ManyToMany(mappedBy = "students")
    List<Teacher> teachers;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    Grade grade;
}
