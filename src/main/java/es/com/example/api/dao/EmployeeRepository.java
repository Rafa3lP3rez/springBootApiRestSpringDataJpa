package es.com.example.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.com.example.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
