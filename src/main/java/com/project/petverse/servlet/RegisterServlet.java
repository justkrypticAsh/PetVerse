package com.project.petverse.servlet;

import java.io.IOException;

import com.project.petverse.dao.UserDAO;
import com.project.petverse.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * RegisterServlet
 * ----------------------------------------------------------
 * Handles user registration.
 * Steps:
 *  1. Take name, email, password from form
 *  2. Check if email exists
 *  3. Create new user
 *  4. Redirect to login page
 * ----------------------------------------------------------
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        UserDAO dao = new UserDAO();

        // Check if email already used
        if (dao.emailExists(email)) {
            response.sendRedirect("register.jsp?error=EmailAlreadyUsed");
            return;
        }

        User user = new User(name, email, pass);

        boolean success = dao.registerUser(user);

        if (success) {
            response.sendRedirect("login.jsp?registered=true");
        } else {
            response.sendRedirect("register.jsp?error=Failed");
        }
    }
}
