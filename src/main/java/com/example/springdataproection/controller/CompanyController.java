package com.example.springdataproection.controller;


import com.example.springdataproection.model.Employee;
import com.example.springdataproection.model.EmployeeProjection;
import com.example.springdataproection.service.CompanyService;
import com.example.springdataproection.service.CompanyServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avi/v1/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyServiceInterface companyService;

    @GetMapping
    public ResponseEntity<List<EmployeeProjection>> getAllCompanyEmployees() {
        return ResponseEntity.ok(companyService.getEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeProjection> getEmployeeById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(companyService.findEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeProjection> addNewEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(companyService.addNewEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeProjection> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(companyService.updateEmployeeById(employee));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<EmployeeProjection> deleteEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(companyService.deleteEmployeeById(employeeId));
    }

}
