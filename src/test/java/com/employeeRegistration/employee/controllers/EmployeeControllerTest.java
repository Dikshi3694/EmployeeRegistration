package com.employeeRegistration.employee.controllers;

import com.employeeRegistration.employee.entities.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

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
    public void saveEmployee() {
    }

    @Test
    public void getListEmployee() {
    }
}