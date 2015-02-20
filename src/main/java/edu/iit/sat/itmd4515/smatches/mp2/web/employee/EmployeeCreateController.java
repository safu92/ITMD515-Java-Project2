/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.web.department;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.service.EmployeeDAO;
import edu.iit.sat.itmd4515.smatches.mp2.web.employee.EmployeeUpdateController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


@WebServlet(name = "EmployeeCreateController", urlPatterns = {"/employee/new"})
public class EmployeeCreateController extends HttpServlet{
 private static final Logger LOG = Logger.getLogger(EmployeeCreateController.class.getName());

    
     @Resource
    Validator validator;
 
    @Inject
    EmployeeDAO employeeDao;    

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOG.info("Inside doGet");

        LOG.info("Dispatching to /employee/new");

      

    //    String id = request.getParameter("deptId");
     //   String name = request.getParameter("deptName");
        //request.setAttribute("customer", svc.findEmployee(id));

      //  request.getRequestDispatcher("/WEB-INF/pages/department/department.jsp").forward(request, response);
         Integer empId = Integer.parseInt(request.getParameter("empId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        java.util.Date bd = null,hd = null;
        java.sql.Date birthDate = null;
        java.sql.Date hireDate = null;
        try {
            bd = sdf.parse(request.getParameter("birthDate"));
                birthDate = new java.sql.Date(bd.getTime());
            hd = sdf.parse(request.getParameter("hireDate"));
                hireDate = new java.sql.Date(hd.getTime());
            
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeCreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Employee e = new Employee(empId,firstName,lastName,gender,birthDate,hireDate);
       
        // validate it
        Set<ConstraintViolation<Employee>> violations = validator.validate(e);

        if (violations.isEmpty()) {
            // provess the update
          request.setAttribute("newEmp",employeeDao.newEmployee(empId,firstName,lastName,gender,birthDate,hireDate));
          request.setAttribute("employees", employeeDao.findEmployees(1));
            request.getRequestDispatcher("/WEB-INF/pages/employee/employees.jsp").forward(request, response);
        } else {
            // not successfully validated, so send the customer and violations
            // back to the user for their additional input

            LOG.info("There are " + violations.size() + " violations.");

            for (ConstraintViolation<Employee> violation : violations) {
                LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                        + "." + violation.getPropertyPath()
                        + " - Invalid Value = "
                        + violation.getInvalidValue()
                        + " - Error Msg = " + violation.getMessage());

            }

            request.setAttribute("employees", e);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/employee/employee.jsp").forward(request, response);

        }

    }

}
