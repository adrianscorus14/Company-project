package com.sda.company.controller;

import com.sda.company.entities.Employee;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


//    @GetMapping("/all")
//    public String getEmployee(Model model) {
//        List<Employee> allEmployees = employeeService.findAll();
//        model.addAttribute("employees", allEmployees);
//        return "employee-list";
//
//    }

//    @PostMapping("/create")
//    public String createEmployee(@Valid Employee employee, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "employee-create";
//        }
//        try {
//            employeeService.save(employee);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/employee/all";
//    }

    @RequestMapping("/go-to-create")
    public String goToCreate(@ModelAttribute Employee employee) {
        return "employee-create";
    }

    @RequestMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-update";
        }

        employeeService.update(employee);

        return "redirect:/employee/all";
    }

    @RequestMapping("/go-to-update/{id}")
    public String goToUpdate(@PathVariable Long id, Model model) {

        model.addAttribute("employee", employeeService.findById(id));
        return "employee-update";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        employeeService.delete(id);
        return "redirect:/employee/all";
    }

    @RequestMapping("/search")
    public String searchByName(@RequestParam(value = "employeeName") String name, Model model){

        List<Employee> allEmployeesByName = employeeService.getAllEmployeesByName(name);
        model.addAttribute("employees", allEmployeesByName);
        return "employee-list";

    }

}
