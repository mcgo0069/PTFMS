package viewlayer;

import javax.servlet.http.*;
import java.io.*;

/**
 * placeholder servlet for when the function is handled in the future
 * 
 * @author: Eddy Su
 */
public class AlertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>All Authors</title>");
            out.println("<style>body{background-color:#FDF5E6;}</style>");
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h2>List of All Authors</h2>");

            out.println("<h2>System Alerts</h2>");
            out.println("<ul><li>No major alerts at the moment.</li></ul>");

            out.println("</center></body></html>");
        }
    }
}
