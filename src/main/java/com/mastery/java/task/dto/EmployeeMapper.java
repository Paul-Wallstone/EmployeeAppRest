package com.mastery.java.task.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {

        final Long employeeId = rs.getLong("employee_id");
        final String firstName = rs.getString("first_name");
        final String lastName = rs.getString("last_name");
        final Long departmentId = rs.getLong("department_id");
        final Gender gender = Gender.valueOf(rs.getString("gender").toUpperCase(Locale.ROOT));
        final String job_title = rs.getString("job_title");
        final Date date_of_birth = rs.getDate("date_of_birth");

        LocalDate localDate = Instant.ofEpochMilli(date_of_birth.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        return new Employee(employeeId, firstName, lastName, departmentId, gender, job_title, localDate);
    }
}
