package viewlayer;

import Command.*;
import Strategy.RoleStrategy;
import Strategy.TransitManagerStrategy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * FrontController servlet that acts as the controller by intercepting all
 * incoming requests and executes the appropriate command
 *
 * uses the command design pattern
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

    private Map<String, Command> commandMap = new HashMap<>();

    /**
     * sets the available commands
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        // Initialize command map
        commandMap.put("RegisterAccount", new RegisterAccountCommand());
        commandMap.put("RegisterVehicle", new RegisterVehicleCommand());
        commandMap.put("LogOutOfService", new LogOutOfServiceCommand());
        commandMap.put("ViewArrivalTimes", new ViewArrivalTimesCommand());
        commandMap.put("ScheduleMaintenance", new ScheduleMaintenanceCommand());
        commandMap.put("ViewReport", new ViewReportCommand());
        commandMap.put("CheckAlerts", new CheckAlertsCommand());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoleStrategy strategy = new TransitManagerStrategy();
        // Delegate request handling to selected strategy
        strategy.handleRequest(request, response);
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

        String action = request.getParameter("action");

        //select command based off of action
        Command command = commandMap.get(action);

        if (command != null) {
            command.execute(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

}
