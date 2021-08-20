package com.mastery.java.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Locale;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table("employee")
public class Employee {
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private Gender gender;
    private String job_title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    public Employee(Long employeeId, String firstName, String lastName, Long departmentId, String gender, String job_title, LocalDate date_of_birth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.gender = Gender.valueOf(gender.toUpperCase(Locale.ROOT));
        this.job_title = job_title;
        this.date_of_birth = date_of_birth;
    }
}
