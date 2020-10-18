package com.sda.company.repository;

import com.sda.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.name like :name%")
     List<Employee> getAllEmployeesBySpecificName(@Param("name") String name);

    List<Employee> findEmployeeByName(String name);

    List<Employee> findAllByCurrentMonth(Integer month);

}
