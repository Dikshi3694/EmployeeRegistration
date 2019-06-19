package com.employeeRegistration.employee.controllers;

import com.employeeRegistration.employee.Services.EmployeeService;
import com.employeeRegistration.employee.entities.Employee;
import com.employeeRegistration.employee.models.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class employeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody EmployeeModel employeeModel) throws Exception{
        return this.employeeService.saveEmp(employeeModel);
    }
}
