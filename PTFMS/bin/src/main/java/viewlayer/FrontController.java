package viewlayer;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import business_layer.Ptfms_db_Manager;
import data_transfer_object.Credential;
import data_transfer_object.Users;

/**
 * FrontController servlet that acts as the controller by intercepting all 
 * incoming requests and forwards them to the appropriate handler based on the 
 * button clicked.To work, the program requires the user credentials for 
 accessing the database.
 * 
 * @author Eddy Su
 * @see java.io.IOException
 * @see javax.servlet
 * @see javax.servlet.http
 * @see business_layer.Ptfms_db_Manager
 * @see data_transfer_object.Credential
 */
public class FrontController extends HttpServlet {

    /**
     * default constructor
     */
    public FrontController(){
        super();
    }
    
    /**
     * Processes HTTP POST requests by extracting user credentials, 
     * identifying the requested action, and forwarding the request to the 
     * appropriate servlet for further handling.
     * 
     * @param request  the HttpServletRequest object that contains the request 
     *                 the client made to the servlet
     * @param response the HttpServletResponse object that contains the response 
     *                 the servlet sends to the client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Declare and define Credential DTO
        Credential cred = new Credential(request.getParameter("username"),
                request.getParameter("password"));
        
        // check user status
        Users user = Ptfms_db_Manager.getByUserCredentials(cred);
        
        if (user.getRole().equals("Operator")){
            request.getRequestDispatcher("/LogOutOfServiceTime").forward(request, response);
        }else if(user.getRole().equals("Transit_Manager")){
            request.getRequestDispatcher("/TransitManagerPage").forward(request, response);
        }
    }
}
