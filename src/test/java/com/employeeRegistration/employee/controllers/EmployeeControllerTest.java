package com.employeeRegistration.employee.controllers;

import com.employeeRegistration.employee.Services.EmployeeService;
import com.employeeRegistration.employee.entities.Employee;
import com.employeeRegistration.employee.models.EmployeeModel;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    public EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveEmployee_whenEmployeeIsRegistered() throws Exception {
        //stub
        Date dOB = new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1994");
        Employee employee  = new Employee( "dikshita" ,"khandke", "F", dOB , "ISE");
        employee.setCreated( new Date(  ) );
        employee.setModified( new Date(  ) );

        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.first_name = "dikshita";
        employeeModel.last_name = "khandke";
        employeeModel.date_of_birth= "03/06/1994";
        employeeModel.gender="F";
        employeeModel.department="ISE";

        when(this.employeeService.saveEmp(employeeModel)).thenReturn(employee);

        String jsonString="{\"first_name\": \"dikshita\", \"last_name\": \"khandke\", \"gender\": \"F\", \"department\": \"ISE\", \"date_of_birth\": \"03/06/1994\" } ";

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/employee/saveEmp").contentType(MediaType.APPLICATION_JSON).content(jsonString);

        // assertion
        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getListEmployee_whenGetEmployees_thenReturnCollectionOfEmployee() throws Exception {
        //stub
        Date dOB = new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1994");
        Employee employee  = new Employee( "dikshita" ,"khandke", "F", dOB , "ISE");
        employee.setCreated( new Date(  ) );
        employee.setModified( new Date(  ) );
        List<Employee> employeeList = Arrays.asList(employee);
        when(this.employeeService.findListOfEmp()).thenReturn(employeeList);

        // request
        MockHttpServletRequestBuilder request = get("/employee/getListOfEmp");

        // assertion
        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect( jsonPath("$[0].first_name", Matchers.is("dikshita")))
                .andExpect( jsonPath("$[0].last_name", Matchers.is("khandke")))
                .andExpect( jsonPath("$[0].gender", Matchers.is("F")))
                .andExpect( jsonPath("$[0].department", Matchers.is("ISE")));
    }
}