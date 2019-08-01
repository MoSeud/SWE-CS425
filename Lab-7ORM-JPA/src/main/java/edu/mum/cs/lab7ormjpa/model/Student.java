package edu.mum.cs.lab7ormjpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentid;
    @Column(nullable = false)
    private String  studentNumber;
    private String firstName;
    private  String middleName;
    private String lastName;
    private Float cgpa;
    private LocalDate enrolmentdate;
    @OneToOne
    private Transcript transcript;
    @ManyToOne
    private ClassRoom classRoom;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa, LocalDate enrolmentdate) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrolmentdate = enrolmentdate;
    }
}
