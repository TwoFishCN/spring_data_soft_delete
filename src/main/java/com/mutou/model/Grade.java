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
@SQLDelete(sql = "UPDATE grade SET deleted_at = now() where id = ?")
@Where(clause = "deleted_at < '1970-01-02'")
public class Grade {

    @Id
    @GeneratedValue
    private int id;

    private int num;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @OneToMany(mappedBy = "grade")
    List<Student> students;
}
