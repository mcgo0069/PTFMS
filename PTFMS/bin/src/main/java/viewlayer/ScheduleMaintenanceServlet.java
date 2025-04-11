package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.ScheduleMaintenance;
import data_transfer_object.vehicle.Vehicle;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ScheduleMaintenanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Vehicle> vehicles;

        if (!isEmpty(request.getParameter("vehicle id"))
                && !isEmpty(request.getParameter("maintenanceTime"))
                && !isEmpty(request.getParameter("description"))) {
            Ptfms_db_Manager.insertScheduleMaintenance(new ScheduleMaintenance(
                    Integer.parseInt(request.getParameter("vehicle id")),
                    java.sql.Date.valueOf(request.getParameter("maintenanceTime")),
                    request.getParameter("description")
            ));
        }

        vehicles = Ptfms_db_Manager.getAllVehicles();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Get Author By ID</title>");
            out.println("<style>");
            out.println("body{background-color:#FDF5E6;}");
            out.println("h3{color:red;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");

            out.println("<h2>Schedule Maintenance Task</h2>");
            out.println("<form action='ScheduleMaintenanceServlet' method='post'>");

            //menu for all vehicle id
            out.println("<label>Vehicle ID:</label><br><select name='vehicle id'>");
            for (Vehicle vehicle : vehicles) {
                out.println("<option value='" + vehicle.getVehicleNumber() + "'>" + vehicle.getVehicleNumber() + "</option>");
            }
            out.println("</select>");

            out.println("<label>Date & Time:</label><br><input type='datetime-local' name='maintenanceTime' required><br><br>");
            out.println("<label>Description:</label><br><textarea name='description'></textarea><br><br>");
            out.println("<button type='submit'>Schedule</button></form>");

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
