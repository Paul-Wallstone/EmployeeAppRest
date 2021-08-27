package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EmployeeDao {


    public Employee save(Employee employee);

    public Employee getEmployeeById(Long id);

    public List<Employee> listEmployee();

    public Boolean removeById(Long id);

    public Boolean update(Employee employee);
}
