/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    "/departments"
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
        LOG.info("Inside doGet");
        switch (request.getServletPath()) {
            case "/departments":
                LOG.info("Dispatching to /departments");
                    response.setContentType("text/html");
                request.setAttribute("departments", departmentDao.findDepartments());
                request.getRequestDispatcher("/WEB-INF/pages/department/departments.jsp").forward(request, response);
                break;
           case "/employee":
             LOG.info("Dispatching to /employee");
  //if (request.getParameter("id")!=null) {
    //                Long id = Long.parseLong(request.getParameter("id"));
      //              request.setAttribute("employee", employeeDao.findById(id));
        //            request.setAttribute("readonly", "readonly");
          //      }

               

           LOG.warning("ID was not passed as a parameter.  Must be a new customer.");
//                messages.put("No ID Error", "This is a message from your controller.  Please enter an ID.");
//                throw new ServletException("No ID was passed.  Try again!");

               request.getRequestDispatcher("/WEB-INF/pages/employee/employee.jsp").forward(request, response);
               break;
        }

    }
    
}
