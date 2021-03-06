
package edu.iit.sat.itmd4515.smatches.mp2.web.employee;

import edu.iit.sat.itmd4515.smatches.mp2.service.EmployeeDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Validator;

@WebServlet(name = "EmployeeController", urlPatterns = {
    "/employee",
    "/employees",
    "/employee/delete"
})
public class EmployeeController extends HttpServlet {
    
  
    
    @Resource
    Validator validator;
 
    @Inject
    EmployeeDAO employeeDao;
       

    private static final Logger LOG
            = Logger.getLogger(EmployeeController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getServletPath()) {
            case "/employees":
                LOG.info("Dispatching to /employees");
                int page = 0;
                    response.setContentType("text/html");
                    if(request.getParameter("page")!=null){
                    page = Integer.parseInt(request.getParameter("page"));
                    }
                    
                    
                request.setAttribute("employees", employeeDao.findEmployees(page));
                request.getRequestDispatcher("/WEB-INF/pages/employee/employees.jsp").forward(request, response);
                break;
           case "/employee":
             LOG.info("Dispatching to /employee");
                
             if (request.getParameter("id")!=null) {
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    //LOG.info(request.getParameter("id"));
                    request.setAttribute("employee", employeeDao.findById(id));
                    request.setAttribute("readonly", "readonly");
                }

               


               request.getRequestDispatcher("/WEB-INF/pages/employee/employee.jsp").forward(request, response);
               break;
               
                 case "/employee/delete":
            request.getRequestDispatcher("/WEB-INF/pages/employee/deleteEmployee.jsp").forward(request, response);
               break;
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

        if (LOG.isLoggable(Level.FINEST)) {
            LOG.finest("Inside doPost");
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>I am doPost");
        }
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
