package com.sda.company.controller;

import com.sda.company.components.CustomFaker;
import com.sda.company.entities.Employee;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rest/employee")
@ControllerAdvice
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomFaker customFaker;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployee(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<Employee> allEmployees = employeeService.findAll(pageSize, pageNo, sortBy);
        if (allEmployees.size() == 0 || allEmployees == null) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);

        }
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/populate")
    public void populateDB(){
        employeeService.saveAll(customFaker.createDummyEmployeeList());

    }

    @GetMapping("/findById")
    public ResponseEntity<Employee> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee, Principal principal) {
        return ResponseEntity.ok(employeeService.save(employee, principal.getName()));
    }

    @RequestMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {

        employeeService.update(employee);
        return ResponseEntity.ok(employee);

    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        employeeService.delete(id);
        return ResponseEntity.ok("Employee was deleted");

    }

    @RequestMapping("/search")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam(value = "employeeName") String name) {

        List<Employee> allEmployeesByName = employeeService.getAllEmployeesByName(name);
        return ResponseEntity.ok(allEmployeesByName);
    }

}
