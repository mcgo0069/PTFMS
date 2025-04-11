package viewlayer;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * FrontController servlet that acts as the controller by intercepting all
 * incoming requests and forwards them to the appropriate handler based on the
 * button clicked.To work, the program requires the user credentials for
 * accessing the database.
 *
 * @author Eddy Su
 * @see java.io.IOException
 * @see javax.servlet
 * @see javax.servlet.http
 * @see business_layer.Ptfms_db_Manager
 * @see data_transfer_object.Credential
 */
public class TransitManagerFrontController extends HttpServlet {

    /**
     * default constructor
     */
    public TransitManagerFrontController() {
        super();
    }

    /**
     * Processes HTTP POST requests by extracting user credentials, identifying
     * the requested action, and forwarding the request to the appropriate
     * servlet for further handling.
     *
     * @param request the HttpServletRequest object that contains the request
     * the client made to the servlet
     * @param response the HttpServletResponse object that contains the response
     * the servlet sends to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Determine which action to perform based on user input
        String action = request.getParameter("action");

        // Dispatch request to appropriate servlet based on action
        switch (action) {
            case "RegisterAccount":
                request.getRequestDispatcher("/RegisterAccountServlet").forward(request, response);
                break;
            case "RegisterVehicle":
                request.getRequestDispatcher("/RegisterVehicleServlet").forward(request, response);
                break;
            case "LogOutOfService":
                request.getRequestDispatcher("/LogOutOfServiceServlet").forward(request, response);
                break;
            case "ViewArrivalTimes":
                request.getRequestDispatcher("/ViewArrivalTimesServlet").forward(request, response);
                break;
            case "ScheduleMaintenance":
                request.getRequestDispatcher("/ScheduleMaintenanceServlet").forward(request, response);
                break;
            case "ViewReport"://do later
                request.getRequestDispatcher("/ViewReportServlet").forward(request, response);
                break;
            case "CheckAlerts":
                request.getRequestDispatcher("/AlertServlet").forward(request, response);
                break;
            default:
                // Send an error response if an invalid action is provided
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                break;
        }

    }
}
