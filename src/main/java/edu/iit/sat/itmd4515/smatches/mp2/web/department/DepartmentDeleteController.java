
package edu.iit.sat.itmd4515.smatches.mp2.web.department;

import edu.iit.sat.itmd4515.smatches.mp2.model.Department;
import edu.iit.sat.itmd4515.smatches.mp2.service.DepartmentDAO;
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


@WebServlet(name = "DepartmentDeleteController", urlPatterns = {"/department/del"})
public class DepartmentDeleteController extends HttpServlet{
 private static final Logger LOG = Logger.getLogger(DepartmentDeleteController.class.getName());

    
     @Resource
    Validator validator;
 
    @Inject
    DepartmentDAO departmentDao;    

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        LOG.info("Dispatching to /department/delete");


        String id = request.getParameter("deptId");
       
        // validate it
        Set<ConstraintViolation<String>> violations = validator.validate(id);

        if (violations.isEmpty()) {
            // provess the update
          request.setAttribute("deleteDept",departmentDao.deleteDepartment(id));
          request.setAttribute("departments", departmentDao.findDepartments());
            request.getRequestDispatcher("/WEB-INF/pages/department/departments.jsp").forward(request, response);
        } else {
            // not successfully validated, so send the customer and violations
            // back to the user for their additional input

            LOG.info("There are " + violations.size() + " violations.");

            for (ConstraintViolation<String> violation : violations) {
                LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                        + "." + violation.getPropertyPath()
                        + " - Invalid Value = "
                        + violation.getInvalidValue()
                        + " - Error Msg = " + violation.getMessage());

            }

            request.setAttribute("department", id);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/department/department.jsp").forward(request, response);

        }

    }

}
