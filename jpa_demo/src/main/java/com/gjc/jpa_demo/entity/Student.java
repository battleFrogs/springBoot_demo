package com.gjc.jpa_demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "student")
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_score")
    private Integer studentScore;


}
