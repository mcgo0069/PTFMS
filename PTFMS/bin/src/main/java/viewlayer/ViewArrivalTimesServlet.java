package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.AssignedRoute;
import data_transfer_object.Transit_Log;
import data_transfer_object.vehicle.Vehicle;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

public class ViewArrivalTimesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Vehicle> vehicles = Ptfms_db_Manager.getAllVehicles();
        List<Transit_Log> transit_logs = Ptfms_db_Manager.getAllTransitLogs();
        List<AssignedRoute> assigned_routes = Ptfms_db_Manager.getAllAssignedRoutes();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add New Author</title>");
            out.println("<style>");
            out.println("body{background-color:#FDF5E6;}");
            out.println("p{color:red;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Enter Vehicle ID</h2>");
            // Query for Author ID
            out.println("<form action='GetAuthorByIdServlet' method='POST'>");
            out.println("<label for='authorID'>Author ID:</label>");
            out.println("<input type='text' id='authorID' name='authorID'><br><br>");
            out.println("</form>");

            //menu for all vehicle id
            out.println("<label>Vehicle ID:</label><br><select name='vehicle id'>");
            for (Vehicle vehicle : vehicles) {
                out.println("<option value='" + vehicle.getVehicleNumber() + "'>" + vehicle.getVehicleNumber() + "</option>");
            }
            out.println("</select>");
            out.println("<button type='submit'>Submit</button>");

            if (!isEmpty(request.getParameter("vehicle id"))) {
                out.println("<h2>View Arrival Times</h2>");
                out.println("<table border='1'><tr><th>Vehicle ID</th><th>Route</th><th>Estimated Arrival</th></tr>");
                out.println("<tr><td>1001</td><td>Blue Line</td><td>14:32</td></tr>");
                out.println("<tr><td>1002</td><td>Green Line</td><td>14:45</td></tr>");

                for (Vehicle vehicle : vehicles) {
                    for (AssignedRoute route : assigned_routes) {
                        for (Transit_Log log : transit_logs) {
                            if (log.getVehicleID() == vehicle.getVehicleNumber()) {
                                out.println("<td>" + vehicle.getVehicleNumber() + "</td>");
                                out.println("<td>" + route.getRoute_id() + "</td>");
                                out.println("<td>" + log.getArrivalTime() + "</td>");
                                break;
                            }
                        }
                    }
                }
            }

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Helper method to check if a string is null or empty
     *
     * @param value The string to check.
     * @return true if the string is null or empty, false otherwise.
     */
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
