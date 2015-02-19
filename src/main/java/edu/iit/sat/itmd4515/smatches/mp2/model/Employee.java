/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.model;

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

    @Size(max = 70)
    private String address;
    @Size(max = 80)
    private String company;
    @NotNull
    private int empId;
    @NotNull
    @Size(max = 60)
    private String email;
    @NotNull
    @Size(max = 40)
    private String firstName;
    @NotNull
    @Size(max = 20)
    private String lastName;


    public Employee() {
    }
    
    public Employee(String address, int empId, String email, String firstName, String lastName, String company) {
        this.address = address;
        this.empId = empId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public Employee(int empId, String firstName, String lastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Get the value of customerId
     *
     * @return the value of customerId
     */
    public int getEmployeeId() {
        return empId;
    }

    /**
     * Set the value of customerId
     *
     * @param customerId new value of customerId
     */
    public void setEmployeeId(int empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Customer{" + "address=" + address + ", company=" + company + ", customerId=" + empId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }


}
