
package edu.iit.sat.itmd4515.smatches.mp2.web.department;

import edu.iit.sat.itmd4515.smatches.mp2.service.DepartmentDAO;
import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;


    @WebServlet(name = "DepartmentController", urlPatterns = {
    "/department",
    "/departments",
    "/department/delete",
    
})
public class DepartmentController extends HttpServlet {
    
  
    
    @Resource
    Validator validator;
 
    @Inject
    DepartmentDAO departmentDao;
       

    private static final Logger LOG
            = Logger.getLogger(DepartmentController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/departments":
                LOG.info("Dispatching to /departments");
                    response.setContentType("text/html");
                request.setAttribute("departments", departmentDao.findDepartments());
                request.getRequestDispatcher("/WEB-INF/pages/department/departments.jsp").forward(request, response);
                break;
           case "/department":  
             LOG.info("Dispatching to /department");
  if (request.getParameter("id")!=null) {
                  String id = request.getParameter("id");
                request.setAttribute("department", departmentDao.findById(id));
              request.setAttribute("readonly", "readonly");
        }


               request.getRequestDispatcher("/WEB-INF/pages/department/department.jsp").forward(request, response);
               break;
               
               
           case "/department/delete":
            request.getRequestDispatcher("/WEB-INF/pages/department/deleteDepartment.jsp").forward(request, response);
               break;
        }

    }
    
}
