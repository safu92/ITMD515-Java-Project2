/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Department;
import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
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
public class DepartmentDAO {

    //@Resource(lookup = "jdbc/yourDS")
    //DataSource dataSource;
    @Resource(lookup = "jdbc/smatchesMp2DS")
    DataSource dataSource;

    
    public List<Department> findDepartments() {
        //JDBC work here
        // return List<Customer>

         List<Department> departments = new ArrayList<>();
        try (Connection c = dataSource.getConnection()) {
           
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from departments");

            while (rs.next()) {
               
            departments.add(new Department(rs.getString("dept_no"),
                        rs.getString("dept_name")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (departments.isEmpty()) {
            return null;
       } else {
          return departments;
      }
    }
    
    public Department findById(String id) {

        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("select * from departments where dept_no = ?");
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Department(rs.getString("dept_no"),
                        rs.getString("dept_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean updateDepartment(String id, String name) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("update departments set dept_name = ? where dept_no=?");
            ps.setString(1, name);
            ps.setString(2, id);
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    
    public boolean newDepartment(String id,String name) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("insert into departments values(?,?)");
            ps.setString(1, id);
            ps.setString(2, name);
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    
    public boolean deleteDepartment(String id) {
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement("delete from departments where dept_no=?");
            ps.setString(1, id);
            
            // and so forth
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
}
