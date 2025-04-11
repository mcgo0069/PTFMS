package viewlayer;

import business_layer.Ptfms_db_Manager;
import data_transfer_object.Users;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

public class RegisterAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        Users user;

            user = new Users(
                    request.getParameter("first_name"),
                    request.getParameter("last_name"),
                    request.getParameter("email"),
                    request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("role")
            );
            if (validation(user)) {
                Ptfms_db_Manager.insertUser(user);
                return;
            }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<h2>Register New Account</h2>");
            out.println("<form action='RegisterAccountServlet' method='post'>");
            out.println("<label>Username:</label><br><input type='text' name='username' required><br><br>");
            out.println("<label>Password:</label><br><input type='password' name='password' required><br><br>");
            out.println("<label>First Name:</label><br><input type='text' name='first_name' required><br><br>");
            out.println("<label>Last Name:</label><br><input type='text' name='last_name' required><br><br>");
            out.println("<label>Email:</label><br><input type='email' name='email' required><br><br>");
            out.println("<label>Role:</label><br><select name='role'>");
            out.println("<option value='operator'>Operator</option><option value='Transit_Manager'>Transit Manager</option>");
            out.println("</select><br><br><button type='submit'>Create Account</button></form>");
        }
    }

    private boolean validation(Users user) {
        return !(isEmpty(user.getUsername()) || isEmpty(user.getPassword())
                || isEmpty(user.getFirstName()) || isEmpty(user.getLastName())
                || isEmpty(user.getEmail()) || isEmpty(user.getRole()));
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
