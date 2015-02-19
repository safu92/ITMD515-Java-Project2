/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp2.web.employee;

import edu.iit.sat.itmd4515.smatches.mp2.model.Employee;
import edu.iit.sat.itmd4515.smatches.mp2.service.CrmService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
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
@WebServlet(name = "CustomerUpdateController", urlPatterns = {"/customer/update"})
public class CustomerUpdateController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CustomerUpdateController.class.getName());

    @Inject
    private CrmService svc;

    @Inject
    private Validator validator;

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

        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        LOG.info("Dispatching to /customer/update");

      

        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("customer", svc.findEmployee(id));

        request.getRequestDispatcher("/WEB-INF/pages/customer/customer.jsp").forward(request, response);

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

        // on POST, build a customer from the request
        Employee c = buildCustomerFromRequest(request);

        // validate it
        Set<ConstraintViolation<Employee>> violations = validator.validate(c);

        if (violations.isEmpty()) {
            // provess the update
            svc.save(c);
            request.getRequestDispatcher("/customers").forward(request, response);
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

            request.setAttribute("customer", c);
            request.setAttribute("violations", violations);
            request.getRequestDispatcher("/WEB-INF/pages/customer/customer.jsp").forward(request, response);

        }

    }

    private Employee buildCustomerFromRequest(HttpServletRequest request) {
        Employee c = new Employee();
       
        return c;
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
