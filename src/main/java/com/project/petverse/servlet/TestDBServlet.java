package com.project.petverse.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.project.petverse.util.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "TestDBServlet", urlPatterns = {"/test-db"})
public class TestDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            try (Connection conn = DBConnection.getConnection();
                 Statement st = conn.createStatement()) {

                out.println("<html><head><title>DB Test</title></head><body style='font-family:Arial,sans-serif;margin:20px;'>");
                out.println("<h2>DB Connection OK</h2>");

                String[] tables = {"users","pets","adoption_requests"};
                for (String t : tables) {
                    try (ResultSet rs = st.executeQuery("SELECT COUNT(*) AS c FROM " + t)) {
                        if (rs.next()) {
                            out.println("<p>Table <b>" + t + "</b> has <b>" + rs.getInt("c") + "</b> rows</p>");
                        }
                    } catch (Exception e) {
                        out.println("<p>Table <b>" + t + "</b> not accessible: " + e.getMessage() + "</p>");
                    }
                }

                out.println("</body></html>");

            } catch (Exception ex) {
                out.println("<html><body><h3>DB Connection ERROR</h3>");
                out.println("<pre>" + ex.getMessage() + "</pre>");
                out.println("</body></html>");
            }
        }
    }
}
