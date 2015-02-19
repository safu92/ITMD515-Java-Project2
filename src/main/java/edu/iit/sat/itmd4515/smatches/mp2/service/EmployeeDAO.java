/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.repository.jdbc.JdbcEmployeeRepositoryImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import static jdk.nashorn.internal.codegen.Compiler.LOG;

/**
 * You could just have a JDBC dao class without all the abstraction examples.
 *
 * In that case, CustomerDAO would have all your JDBC code to fetch, retrieve
 * save, delete and build Customer objects to/from the database
 * 
 * In this example, it is presented as a Stateless EJB (just with that one
 * annotation @Stateless).  You could then refer to this with @EJB annotation
 * in other Servlet code
 *
 * @author spyrisos
 */
@Stateless
public class EmployeeDAO {

    //@Resource(lookup = "jdbc/yourDS")
    //DataSource dataSource;
    @Resource(lookup = "jdbc/smatchesMp2DS")
    DataSource dataSource;

    
    public List<Employee> findEmployees() {
        //JDBC work here
        // return List<Customer>
        
         List<Employee> customers = new ArrayList<>();
      

        try (Connection c = dataSource.getConnection()) {
if(c==null){                LOG.info("null");
}
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from employees where emp_no=10001");

            while (rs.next()) {
                customers.add(new Employee(rs.getInt("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (customers.isEmpty()) {
            return null;
        } else {
            return customers;
        }
    }
    
    public Employee findById(Long id) {

        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("select * from employees where emp_no = ?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEmployeeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
