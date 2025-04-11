package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.vehicle.Vehicle;
import data_transfer_object.vehicle.VehicleFactory;
import data_transfer_object.vehicle.VehicleType;
import javax.servlet.http.*;
import java.io.*;

/**
 * servlet for registering a new vehicle
 *
 * @author Eddy Su
 */
public class RegisterVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Vehicle vehicle;

        //if there is input, proccess it
        if (!isEmpty(request.getParameter("vehicle type"))) {
            //builds the vehicle for the selected type
            vehicle = switch (request.getParameter("vehicle type")) {
                case "Diesel_Bus" ->
                    VehicleFactory.buildVehicle(VehicleType.Diesel_Bus);
                case "Electric_Light_Rail" ->
                    VehicleFactory.buildVehicle(VehicleType.Electric_Light_Rail);
                case "Diesel_Electric_Train" ->
                    VehicleFactory.buildVehicle(VehicleType.Diesel_Electric_Train);
                default ->
                    null;
            };
            if (vehicle != null) {
                Ptfms_db_Manager.insertVehicle(vehicle);
            }
            response.sendRedirect(request.getHeader("Referer"));
            return;
        }

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
            out.println("<h2>Register Vehicle</h2>");
            out.println("<form action='RegisterVehicleServlet' method='post'>");
            out.println("<label>Role:</label><br><select name='vehicle type'>");
            out.println("<option value='Diesel_Bus'>Diesel_Bus</option>"
                    + "<option value='Electric_Light_Rail'>Electric_Light_Rail</option>"
                    + "<option value='Diesel_Electric_Train'>Diesel_Electric_Train</option>");
            out.println("</select>");
            out.println("<button type='submit'>Register</button></form>");
            out.println("</center></body></html>");
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
