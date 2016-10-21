package com.mutou.model;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by MuTouRain on 2016/10/21.
 * .
 */
@Entity
@Data
@SQLDelete(sql = "UPDATE teacher SET deleted_at = now() where id = ?")
@Where(clause = "deleted_at < '1970-01-02'")
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String type;
    private Timestamp birthday;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Student> students;


}
