package com.sda.company.service;

import com.sda.company.entities.Employee;
import com.sda.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private EmployeeRepository employeeRepository;
    private List<Employee> employeeListWithStartDate;


    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private List<Employee> findEmployeesWithStartDateInMonth(Integer currentMonth) {

        return employeeRepository.findAllByCurrentMonth(currentMonth);

    }

    public void sendWelcomeEmailToEmployeesInCurrentMonth() {
        Integer currentMonth = LocalDate.now().getMonth().getValue();
        List<Employee> employeesWithStartDate = findEmployeesWithStartDateInMonth(currentMonth);
        for (Employee employee : employeesWithStartDate) {
            System.out.println("Welcome to the company! Mr/Mrs  " + employee.getName());
        }
    }


}
