package com.example.springdataproection.service;

import com.example.springdataproection.model.Employee;
import com.example.springdataproection.model.EmployeeProjection;

import java.util.List;

public interface CompanyServiceInterface {

    public List<EmployeeProjection> getEmployees();

    public EmployeeProjection findEmployeeById(Long employeeId);

    public EmployeeProjection addNewEmployee(Employee employee);

    public EmployeeProjection updateEmployeeById(Employee employee);

    public EmployeeProjection deleteEmployeeById(Long employeeId);

}
