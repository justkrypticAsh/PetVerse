package com.project.petverse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Hello</title></head>");
        out.println("<body style='font-family:Arial,sans-serif;margin:40px;'>");
        out.println("<h2>Hello from PetVerse Servlet (Jakarta 6)!</h2>");
        out.println("<p>Your servlet is working successfully!</p>");
        out.println("<a href='" + req.getContextPath() + "'>Back to Home</a>");
        out.println("</body></html>");
    }
}
