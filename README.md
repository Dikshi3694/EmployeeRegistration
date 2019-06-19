# EmployeeRegistration

Problem Statement : Employee Portal

Use Case 1: Employee Registration
            As a user, I should be able to Register an employee with following details:
            First Name 
            Last Name 
            Gender 
            Date of Birth 
            Department 

Use Case 2: Employee List 
            As a user, I should be able to see all the employee details in a tabular form (or any other way) in ascending order by first name 

Database Used: MySql
Code Tested : POstman Calls 

Use Case 1 :
Postman URL : "http://localhost:9001/employee/saveEmp"
Request Body : {
                    "first_name":"aadya",
                    "last_name":"khandke",
                    "gender":"F",
                    "date_of_birth":"03/06/1994",
                    "department":"ISE"
               }
               
Use Case 2 :
Postman URL : "http://localhost:9001/employee/getListOfEmp"
