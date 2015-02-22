
package edu.iit.sat.itmd4515.smatches.mp2.service;

import edu.iit.sat.itmd4515.smatches.mp2.model.Department;
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


@Stateless
public class DepartmentDAO {

    @Resource(lookup = "jdbc/smatchesMp2DS")
    DataSource dataSource;

    
    public List<Department> findDepartments() {

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
