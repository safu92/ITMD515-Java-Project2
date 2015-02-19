/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.web.department;

import edu.iit.sat.itmd4515.smatches.mp2.web.department.*;
import edu.iit.sat.itmd4515.smatches.mp2.model.Department;
import edu.iit.sat.itmd4515.smatches.mp2.service.DepartmentDAO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

/**
 *
 * @author spyrisos
 */
@WebServlet(name = "DepartmentUpdateController", urlPatterns = {"/department/update"})
public class DepartmentUpdateController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DepartmentUpdateController.class.getName());

    
     @Resource
    Validator validator;
 
    @Inject
    DepartmentDAO departmentDao;


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

        LOG.info("Inside doGet");

        LOG.info("Dispatching to /department/update");

      

    //    String id = request.getParameter("deptId");
     //   String name = request.getParameter("deptName");
        //request.setAttribute("customer", svc.findEmployee(id));

      //  request.getRequestDispatcher("/WEB-INF/pages/department/department.jsp").forward(request, response);
        String id = request.getParameter("deptId");
        String name = request.getParameter("deptName");
        
      Department d = new Department(request.getParameter("deptId"),request.getParameter("deptName"));
       
        // validate it
        Set<ConstraintViolation<Department>> violations = validator.validate(d);

        if (violations.isEmpty()) {
            // provess the update
          request.setAttribute("updateDept",departmentDao.updateDepartment(id,name));
          request.setAttribute("departments", departmentDao.findDepartments());
            request.getRequestDispatcher("/WEB-INF/pages/department/departments.jsp").forward(request, response);
        } else {
            // not successfully validated, so send the customer and violations
            // back to the user for their additional input

            LOG.info("There are " + violations.size() + " violations.");

            for (ConstraintViolation<Department> violation : violations) {
                LOG.info("### " + violation.getRootBeanClass().getSimpleName()
                        + "." + violation.getPropertyPath()
                        + " - Invalid Value = "
                        + violation.getInvalidValue()
                        + " - Error Msg = " + violation.getMessage());

            }

            request.setAttribute("department", d);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/department/department.jsp").forward(request, response);

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

