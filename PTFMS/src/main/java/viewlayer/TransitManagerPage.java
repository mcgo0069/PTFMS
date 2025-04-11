/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The servlet where the commands available to the transit manager is shown
 * 
 * @author Eddy Su
 */
public class TransitManagerPage extends HttpServlet {

    /**
     * default constructor
     */
    public TransitManagerPage() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    /**
     * Handles POST requests to process form submission and add a new author. If
     * form data is missing, redirects to the GET method.
     *
     * @param request the HTTP request
     * @param response the HTTP response
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an input-output error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Transit Manager Menu</title>");
            out.println("<style>");
            out.println("body{background-color:#FDF5E6;}");
            out.println("p{color:red;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Transit Manager Menu</h2>");
            // Display the options
            out.println("<form action='TransitManagerFrontController' method='POST'>");
            out.println("<button type='submit' name='action' value='RegisterAccount'>Register New Account</button><br><br>");
            out.println("<button type='submit' name='action' value='LogOutOfService'>Log Out-of-Service Times</button><br><br>");
            out.println("<button type='submit' name='action' value='RegisterVehicle'>Register Vehicle</button><br><br>");
            out.println("<button type='submit' name='action' value='ViewArrivalTimes'>View Arrival Times</button><br><br>");
            out.println("<button type='submit' name='action' value='ScheduleMaintenance'>Schedule Maintenance Tasks</button><br><br>");
            out.println("<button type='submit' name='action' value='ViewReport'>View Report</button><br><br>");
            out.println("<button type='submit' name='action' value='CheckAlerts'>Check for Alerts</button>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
