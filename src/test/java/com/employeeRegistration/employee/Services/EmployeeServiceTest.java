package com.employeeRegistration.employee.Services;

import com.employeeRegistration.employee.entities.Employee;
import com.employeeRegistration.employee.models.EmployeeModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    public  EmployeeService employeeService;

    public Employee employee;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveEmployee_whenEmployeeIsRegistered() throws Exception{

        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.first_name = "dikshita";
        employeeModel.last_name = "khandke";
        employeeModel.date_of_birth= "03/06/1994";
        employeeModel.gender="F";
        employeeModel.department="ISE";

        Employee  employee = this.employeeService.saveEmp( employeeModel );
        assertEquals(0, employee.getEmp_id());
        assertEquals("dikshita", employee.getFirst_name());
        assertEquals("khandke", employee.getLast_name());
        assertEquals("F", employee.getGender());
        assertEquals("ISE", employee.getDepartment());

    }

    @Test
    public void getListEmployee_whenGetEmployees_thenReturnCollectionOfEmployee() {

        //At this point DB is having 5 records
        //Best practice to write sql insert and insert required records and check against them
        List<Employee> list = this.employeeService.findListOfEmp();
        assertEquals(5, list.size());

    }
}