package com.employeeRegistration.employee.Services;

import com.employeeRegistration.employee.Repository.IEmployeeRepository;
import com.employeeRegistration.employee.entities.Employee;
import com.employeeRegistration.employee.models.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmployeeService {

    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    public void setiEmployeeRepository(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }

    public Employee saveEmp (EmployeeModel employeeModel) throws Exception{

        Date dOB = new SimpleDateFormat("dd/MM/yyyy").parse(employeeModel.date_of_birth);
        Employee employee = new Employee(employeeModel.first_name,employeeModel.last_name,employeeModel.gender,dOB,employeeModel.department);
        employee.setCreated(new Date());
        employee.setModified(new Date());
    return this.iEmployeeRepository.save(employee);
    }
}
