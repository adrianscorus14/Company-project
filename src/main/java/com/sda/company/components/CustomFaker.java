package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.entities.Address;
import com.sda.company.entities.Department;
import com.sda.company.entities.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomFaker {

    public List<Employee> createDummyEmployeeList() {
        Faker faker = new Faker();

        Department department = new Department();
        department.setId(1L);

        List<Employee> fakeEmployeeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            Address address = new Address();
            address.setHomeAddress(faker.address().city());

            Employee employee = new Employee();
            employee.setName(faker.name().fullName());
            employee.setDepartment(department);
            employee.setAddressList(Arrays.asList(address));
            employee.setCurrentMonth(faker.number().numberBetween(1, 12));
            employee.setTimeOfCreation(LocalDateTime.now());
            employee.setCreatedBy("byJavaFaker");

            fakeEmployeeList.add(employee);
        }
        return fakeEmployeeList;
    }
}
