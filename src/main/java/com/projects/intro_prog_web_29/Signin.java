package com.projects.intro_prog_web_29;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "signin", value = "/signin")
public class Signin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Get all the data from the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String data_nascita = request.getParameter("data_nascita");
        String telefono = request.getParameter("telefono");
        String password_check = request.getParameter("password_check");
        // The password check is already done on the frontend, so it is not necessary to check it here

        // Connect to the database and query it
        Connection con = null;
        try{
            // Connect to derby database, to check if the user exists
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/rubbish");

            // Check if the username already exists
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            boolean username_exists = res.next();

            if (username_exists) {
                // If there is already a user with the same username, redirect to the registration page
                // with an error message, to let the user know that the username is already taken
                request.setAttribute("error", "Username already exists");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }  else {
                // Otherwise write the user in the database, and redirect him to the success page
                query = "INSERT INTO users VALUES ('" + username + "', '" + email + "', '" + password + "', '" + data_nascita + "', '" + telefono + "', 'SI ')";
                stmt.executeUpdate(query);
                request.getRequestDispatcher("/registrazione_confermata.jsp").forward(request, response);
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
