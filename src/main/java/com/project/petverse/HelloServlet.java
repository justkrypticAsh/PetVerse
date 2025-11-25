package com.project.petverse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head><title>Hello</title></head><body style='font-family:Arial,sans-serif;margin:40px;'>");
            out.println("<h2>Hello from PetVerse Servlet!</h2>");
            out.println("<p>This means servlets are working.</p>");
            out.println("<p><a href='" + req.getContextPath() + "/'>Back to Home</a></p>");
            out.println("</body></html>");
        }
    }
}
