package com.employeeRegistration.employee.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {

        private int emp_id;
        private String first_name;
        private String last_name;
        private String gender;
        private Date date_of_birth;
        private String department;
        private Date created;
        private Date modified;

        public Employee(String first_name, String last_name, String gender, Date date_of_birth, String department){
            this.first_name =first_name;
            this.last_name =last_name;
            this.gender =gender;
            this.date_of_birth =date_of_birth;
            this.department =department;
        }
        @Id
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Column(nullable = false)
    @Size(min = 1)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    @Column(nullable = false)
    @Size(min = 1)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    }


