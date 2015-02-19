/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.repository.EmployeeRepository;
import edu.iit.sat.itmd4515.smatches.mp2.repository.jdbc.JdbcEmployeeRepository;
import java.util.Collection;
import javax.inject.Inject;

/**
 *
 * @author spyrisos
 */
public class CrmServiceImpl implements CrmService {

    //private CustomerRepository customerRepository = new SimpleCustomerRepositoryImpl();
//    @Inject @SimpleCustomerRepository
    @Inject @JdbcEmployeeRepository
    private EmployeeRepository employeeRepository;

    public CrmServiceImpl() {
    }
    
    @Override
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Collection<Employee> findEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean save(Employee c) {
        return employeeRepository.save(c);
    }

    
}
