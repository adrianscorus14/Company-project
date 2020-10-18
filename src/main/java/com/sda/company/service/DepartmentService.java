package com.sda.company.service;

import com.sda.company.entities.Department;
import com.sda.company.entities.Employee;
import com.sda.company.exceptions.EmployeeNotFoundException;
import com.sda.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {

        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department getById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (!department.isPresent()) {
            throw new EmployeeNotFoundException("Employee with id: " + id + " was not found!");
        }
        return department.get();
    }


    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    public void delete (Department department){
        departmentRepository.delete(department);
    }
}
