package com.sda.company.service;

import com.sda.company.entities.Employee;
import com.sda.company.exceptions.EmployeeNotFoundException;
import com.sda.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    //Ca sa injectam
    EmployeeRepository employeeRepository;

    public EmployeeService(@Autowired EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
//        if (employeePage.getContent().isEmpty() || employeePage.getContent() == null) {
//            throw new EmployeeNotFoundException("No Employees are present in the current list ");
//        }
//        return employeePage.getContent();
        return Optional.of(employeePage.getContent()).orElseThrow(() -> new EmployeeNotFoundException("No Employees are present in the current list "));
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id: " + id + " was not found!");
        }
        return employee.get();
    }

    public Employee save(Employee employee, String userName) {
        employee.setCreatedBy(userName);

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public List<Employee> findAllEmployeesByName(String name) {
        return employeeRepository.getAllEmployeesBySpecificName(name);
    }


    public Employee update(Employee employee) {

        return employeeRepository.save(employee);

    }

    public void delete(Long id) {

        employeeRepository.deleteById(id);

    }

    public List<Employee> saveAll(List<Employee> employeeList) {

        List<Employee> employeeList1 = employeeRepository.saveAll(employeeList);
        return employeeList1;

    }
}
