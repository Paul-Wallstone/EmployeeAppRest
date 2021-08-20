package com.mastery.java.task.dto;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;


import java.util.List;

@Getter
@Setter
@Component
public class EmployeeWrapper {
    private List<Long> removeList;
}
