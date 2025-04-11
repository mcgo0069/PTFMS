package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.AssignedRoute;
import data_transfer_object.Transit_Log;
import data_transfer_object.vehicle.Vehicle;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

/**
 * servlet for viewing vehicle arrival times
 * 
 * @author Eddy Su
 */
public class ViewArrivalTimesServlet extends HttpServlet {
private static boolean viewTable = false;
    /**
     * 
     * @param request
     * @param response
     * @throws IOException 
     */
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

            //menu for all vehicle id
            out.println("<label>Vehicle ID:</label><br><select name='vehicle id'>");
            for (Vehicle vehicle : vehicles) {
                out.println("<option value='" + vehicle.getVehicleNumber() + "'>" + vehicle.getVehicleNumber() + "</option>");
            }
            out.println("</select>");
            out.println("<button type='submit'>Submit</button>");

            if (request.getParameter("action").equals("vehicle id")) {
                out.println("<h2>View Arrival Times</h2>");
                out.println("<table border='1'><tr><th>Vehicle ID</th><th>Route</th><th>Estimated Arrival</th></tr>");

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
