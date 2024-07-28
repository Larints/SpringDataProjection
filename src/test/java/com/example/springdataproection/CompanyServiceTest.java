package com.example.springdataproection;

import com.example.springdataproection.controller.CompanyController;
import com.example.springdataproection.model.Employee;
import com.example.springdataproection.model.EmployeeProjection;
import com.example.springdataproection.service.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(CompanyController.class)
@ExtendWith(SpringExtension.class)
public class CompanyServiceTest {

    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldReturn_AllEmployees() throws Exception {
        EmployeeProjection employeeProjection = new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public String getPosition() {
                return "Developer";
            }

            @Override
            public String getDepartmentName() {
                return "IT";
            }
        };
        when(companyService.getEmployees()).thenReturn(Collections.singletonList(employeeProjection));

        mockMvc.perform(get("/avi/v1/company")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].fullName").value("John Doe"))
                .andExpect(jsonPath("$[0].position").value("Developer"))
                .andExpect(jsonPath("$[0].departmentName").value("IT"));

        verify(companyService, times(1)).getEmployees();
    }

    @Test
    public void shouldReturn_EmployeeById() throws Exception {
        EmployeeProjection employeeProjection = new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public String getPosition() {
                return "Developer";
            }

            @Override
            public String getDepartmentName() {
                return "IT";
            }
        };
        when(companyService.findEmployeeById(1L)).thenReturn(employeeProjection);

        mockMvc.perform(get("/avi/v1/company/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.position").value("Developer"))
                .andExpect(jsonPath("$.departmentName").value("IT"));

        verify(companyService, times(1)).findEmployeeById(1L);
    }

    @Test
    public void should_AddNewEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setPosition("Developer");
        employee.setSalary(1000.0);

        EmployeeProjection employeeProjection = new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public String getPosition() {
                return "Developer";
            }

            @Override
            public String getDepartmentName() {
                return "IT";
            }
        };
        when(companyService.addNewEmployee(any(Employee.class))).thenReturn(employeeProjection);

        mockMvc.perform(post("/avi/v1/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.position").value("Developer"))
                .andExpect(jsonPath("$.departmentName").value("IT"));

        verify(companyService, times(1)).addNewEmployee(any(Employee.class));
    }

    @Test
    public void should_UpdateEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setPosition("Senior Developer");
        employee.setSalary(2000.0);

        EmployeeProjection employeeProjection = new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public String getPosition() {
                return "Senior Developer";
            }

            @Override
            public String getDepartmentName() {
                return "IT";
            }
        };
        when(companyService.updateEmployeeById(any(Employee.class))).thenReturn(employeeProjection);

        mockMvc.perform(put("/avi/v1/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.position").value("Senior Developer"))
                .andExpect(jsonPath("$.departmentName").value("IT"));

        verify(companyService, times(1)).updateEmployeeById(any(Employee.class));
    }

    @Test
    public void shouldDeleteEmployee() throws Exception {
        EmployeeProjection employeeProjection = new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "John Doe";
            }

            @Override
            public String getPosition() {
                return "Developer";
            }

            @Override
            public String getDepartmentName() {
                return "IT";
            }
        };
        when(companyService.deleteEmployeeById(1L)).thenReturn(employeeProjection);

        mockMvc.perform(delete("/avi/v1/company/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.position").value("Developer"))
                .andExpect(jsonPath("$.departmentName").value("IT"));

        verify(companyService, times(1)).deleteEmployeeById(1L);
    }


}
