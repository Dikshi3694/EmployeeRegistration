package com.employeeRegistration.employee.Repository;

import com.employeeRegistration.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends CrudRepository< Employee, String> {

}
