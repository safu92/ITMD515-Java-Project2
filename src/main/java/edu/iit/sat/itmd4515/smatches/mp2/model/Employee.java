/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.model;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Package structure courtesy of the good folks at Spring
 *
 * https://github.com/spring-projects/spring-petclinic
 *
 * @author spyrisos
 */
public class Employee {

   
    @NotNull
    private int empId;
    private String gender;
    @NotNull
    @Size(max = 40)
    private String firstName;
    @NotNull
    @Size(max = 20)
    private String lastName;
    private Date birthDate;
    private Date hireDate;

    public Employee() {
    }
    
    public Employee(int empId,String firstName, String lastName,String gender,Date birthDate,Date hireDate) {
        this.gender = gender;
        this.empId = empId;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
    }

   

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Employee{" + "birthDate=" + birthDate + ", hireDate=" + hireDate + ", employeeId=" + empId + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }


}
