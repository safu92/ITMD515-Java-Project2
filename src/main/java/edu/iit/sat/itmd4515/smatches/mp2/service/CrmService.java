/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import java.util.Collection;

/**
 *
 * @author spyrisos
 */
public interface CrmService {
    Collection<Employee> findEmployees();
    Employee findEmployee(Long id);
    boolean save(Employee e);
}
