/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import java.sql.Connection;
import java.sql.Date;
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

    
    public List<Employee> findEmployees(int page) {
        //JDBC work here
        // return List<Customer>

         List<Employee> employees = new ArrayList<>();
        try (Connection c = dataSource.getConnection()) {
            Statement s = c.createStatement();
            if(page!=0){
                page = page - 1;
            }
            ResultSet rs = s.executeQuery("select * from employees order by emp_no limit "+page +"0,10");

            while (rs.next()) {
               
employees.add(new Employee(rs.getInt("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getDate("birth_date"),
                        rs.getDate("hire_date")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (employees.isEmpty()) {
            return null;
       } else {
          return employees;
      }
    }
    
    public Employee findById(int id) {

        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("select * from employees where emp_no = ?");
            ps.setInt(1, id);
             
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               
            return new Employee(rs.getInt("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getDate("birth_date"),
                        rs.getDate("hire_date"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean updateEmployee(int empId,String firstName,String lastName,String gender,Date birthDate,Date hireDate) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("update employees set first_name = ?, last_name = ?, gender = ?, birth_date = ?, hire_date = ? where emp_no = ?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setDate(4, birthDate);
            ps.setDate(5, hireDate);
            ps.setInt(6, empId);
            
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    
    public boolean newEmployee(int empId,String firstName,String lastName,String gender,Date birthDate,Date hireDate) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("insert into employees values(?,?,?,?,?,?)");
            ps.setInt(1, empId);
            ps.setDate(2, birthDate);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, gender);
            ps.setDate(6, hireDate);
            
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    
}
