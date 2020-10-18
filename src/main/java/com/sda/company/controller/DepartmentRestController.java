package com.sda.company.controller;

import com.sda.company.entities.Department;
import com.sda.company.entities.Employee;
import com.sda.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/allDep")
    public ResponseEntity<List<Department>> getAllDep() {
        List<Department> departmentList = departmentService.getAll();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/depById")
    public ResponseEntity<Department> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }


    @PostMapping("/createDep")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.save(department));
    }

    @RequestMapping("/updateDep")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.update(department));
    }

    @RequestMapping("/deleteDep")
    public void deleteDepartment (@RequestBody Department department){
        departmentService.delete(department);
    }

}
