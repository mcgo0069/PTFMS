package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.Station;
import data_transfer_object.Transit_Log;
import data_transfer_object.Users;
import data_transfer_object.vehicle.Vehicle;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.List;

public class LogOutOfServiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Vehicle> vehicles = Ptfms_db_Manager.getAllVehicles();
        List<Station> stations = Ptfms_db_Manager.getAllStations();

        Transit_Log log = new Transit_Log(
                Integer.parseInt(request.getParameter("station id")),
                Integer.parseInt(request.getParameter("vehicle id")),
                request.getParameter("ArrivalTime"),
                request.getParameter("DepartureTime")
        );

        if (validation(log)) {
            Ptfms_db_Manager.insertLog(log);
            return;
        }

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
            out.println("<h2>Log Vehicle Out-of-Service Time</h2>");
            out.println("<form action='OutOfServiceServlet' method='post'>");
            //menu for all vehicle id
            out.println("<label>Vehicle ID:</label><br><select name='vehicle id'>");
            for (Vehicle vehicle : vehicles) {
                out.println("<option value='" + vehicle.getVehicleNumber() + "'>" + vehicle.getVehicleNumber() + "</option>");
            }
            out.println("</select>");
            //menu for all stations
            out.println("<label>Vehicle ID:</label><br><select name='station id'>");
            for (Station station : stations) {
                out.println("<option value='" + station.getID() + "'>" + station.getAddress() + "</option>");
            }
            out.println("</select>");
            out.println("<label>Arrival Time:</label><br><input type='datetime-local' name='ArrivalTime' required><br><br>");
            out.println("<label>Departure Time:</label><br><input type='datetime-local' name='DepartureTime' required><br><br>");
            out.println("<button type='submit'>Submit</button></form>");

            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private boolean validation(Transit_Log log) {
        return !(isEmpty(String.valueOf(log.getVehicleID())) || isEmpty(String.valueOf(log.getStationID()))
                || isEmpty(log.getArrivalTime()) || isEmpty(log.getDepartureTime()));
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
