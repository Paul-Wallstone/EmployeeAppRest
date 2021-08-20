package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.EmployeeWrapper;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.mastery.java.task.PagesPathEnum.HOME_PAGE;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private List<Employee> employees = new ArrayList<>();


    @GetMapping("/list")
    public String showAll(Model model) {
        employees = new ArrayList<>(employeeService.listEmployee());
        Comparator<Employee> comparator = Comparator.comparing(obj -> obj.getEmployeeId());
        Collections.sort(employees, comparator);
        model.addAttribute("employees", employees);
        return HOME_PAGE.getPath();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("employee") Employee employee) {
        if (employee.getFirstName() != "" && employee.getLastName() != ""
                && employee.getDepartmentId() != null
                && employee.getJob_title() != "" && employee.getDate_of_birth() != null) {
            employeeService.save(employee);
        }
        return "redirect:/employee/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("wrapper") EmployeeWrapper wrapper) {
        for (Long id : wrapper.getRemoveList()) {
            employeeService.removeById(id);
        }
        return "redirect:/employee/list";
    }

    @PostMapping("/edit")
    public String edit(Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @ModelAttribute(value = "employee")
    public Employee newEntity() {
        return new Employee();
    }

    @ModelAttribute(value = "wrapper")
    public EmployeeWrapper newList() {
        return new EmployeeWrapper();
    }
}
