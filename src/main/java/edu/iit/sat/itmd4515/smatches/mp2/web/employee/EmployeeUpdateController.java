
package edu.iit.sat.itmd4515.smatches.mp2.web.employee;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.service.EmployeeDAO;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
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

@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/employee/update"})
public class EmployeeUpdateController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(EmployeeUpdateController.class.getName());


    @Resource
    Validator validator;

    @Inject
    EmployeeDAO employeeDao;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        LOG.info("Dispatching to /employee/update");

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
            Logger.getLogger(EmployeeUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Employee e = new Employee(empId,firstName,lastName,gender,birthDate,hireDate);
       // validate it
        Set<ConstraintViolation<Employee>> violations = validator.validate(e);

        if (violations.isEmpty()) {
            // provess the update
          //  svc.save(c);
               request.setAttribute("updateEmp",employeeDao.updateEmployee(empId,firstName,lastName,gender,birthDate,hireDate));
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

            request.setAttribute("customer", e);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/customer/customer.jsp").forward(request, response);

    }
    }
 /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

