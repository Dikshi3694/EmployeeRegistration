package com.employeeRegistration.employee.Services;

import com.employeeRegistration.employee.entities.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    public Employee employee;

    @Before
    public void setUp() throws Exception {

        Date dOB = new SimpleDateFormat("dd/MM/yyyy").parse(" 03/06/1994");

        employee.setFirst_name( "dikshita" );
        employee.setLast_name( "khandke" );
        employee.setDate_of_birth(dOB);
        employee.setDepartment( "ISE" );
        employee.setGender( "F" );
        employee.setCreated( new Date(  ) );
        employee.setModified( new Date(  ) );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveEmp() {

    }

    @Test
    public void findListOfEmp() {
    }
}