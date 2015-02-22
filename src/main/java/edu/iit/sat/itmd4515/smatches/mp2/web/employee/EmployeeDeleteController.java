
package edu.iit.sat.itmd4515.smatches.mp2.web.department;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.service.EmployeeDAO;
import java.io.IOException;
import java.util.Set;
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


@WebServlet(name = "EmployeeDeleteController", urlPatterns = {"/employee/del"})
public class EmployeeDeleteController extends HttpServlet{
 private static final Logger LOG = Logger.getLogger(EmployeeDeleteController.class.getName());

    
     @Resource
    Validator validator;
 
    @Inject
    EmployeeDAO employeeDao;    

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOG.info("Dispatching to /employee/delete");

      

        int id = Integer.parseInt(request.getParameter("empId"));

        // validate it
        Set<ConstraintViolation<Integer>> violations = validator.validate(id);

        if (violations.isEmpty()) {
            // provess the update
          request.setAttribute("deleteEmp",employeeDao.deleteEmployee(id));
          request.setAttribute("employees", employeeDao.findEmployees(1));
            request.getRequestDispatcher("/WEB-INF/pages/employee/employees.jsp").forward(request, response);
        } else {
            // not successfully validated, so send the customer and violations
            // back to the user for their additional input

            LOG.info("There are " + violations.size() + " violations.");

            for (ConstraintViolation<Integer> violation : violations) {
                LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                        + "." + violation.getPropertyPath()
                        + " - Invalid Value = "
                        + violation.getInvalidValue()
                        + " - Error Msg = " + violation.getMessage());

            }

            request.setAttribute("employee", id);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/employee/employee.jsp").forward(request, response);

        }

    }

}