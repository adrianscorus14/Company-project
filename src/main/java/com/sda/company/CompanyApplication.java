package com.sda.company;

import com.sda.company.entities.Department;
import com.sda.company.entities.Employee;
import com.sda.company.repository.EmployeeRepository;
import com.sda.company.service.DepartmentService;
import com.sda.company.service.EmailService;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CompanyApplication {

//    @Autowired
//    HelloService helloService;
//    @Autowired
//    DepartmentService departmentService;
//    @Autowired
//    EmployeeService employeeService;
//    @Autowired
//    EmailService emailService;


    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);

    }

//    @Override
//    public void run(String... args) throws Exception {
//        Department deptHR = new Department();
//        deptHR.setName("HR");
////
////        departmentService.save(departmentIT);
//
//        Department deptWithId = departmentService.getById(3L);
//
//        Employee employeeExample = new Employee();
//        employeeExample.setName("DAVID");
//        employeeExample.setDepartment(deptHR);


//        employeeService.save(employeeExample);

//        System.out.println(departmentService.getAll());
//        System.out.println(employeeService.getAll());

//        System.out.println(employeeService.getAllEmployeesByName("D"));

//        emailService.sendWelcomeEmailToEmployeesInCurrentMonth();


//    }
}
