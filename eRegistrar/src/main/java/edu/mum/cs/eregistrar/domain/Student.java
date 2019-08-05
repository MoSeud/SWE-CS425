package edu.mum.cs.eregistrar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull
    private Long studentNumber;
    @NotNull
    private String firstName;

    private String middleName;
    @NotNull
    private String lastName;

    private Double cgpa;
    @NotNull
    private LocalDate enrollmentDate;
    @NotNull
    private  boolean isInternational;


}
