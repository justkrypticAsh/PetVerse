package com.project.petverse.servlet;

import java.io.IOException;

import com.project.petverse.dao.AdoptionRequestDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adopt")
public class AdoptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int petId = Integer.parseInt(req.getParameter("id"));

        // Get existing session only (do NOT create new)
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Integer userId = (Integer) session.getAttribute("userId");
        AdoptionRequestDAO dao = new AdoptionRequestDAO();

        // Already adopted?
        if (dao.isPetAdopted(petId)) {
            resp.sendRedirect("home?adopted=already");
            return;
        }

        // Create adoption entry
        boolean success = dao.createRequest(petId, userId);

        if (success)
            resp.sendRedirect("home?adopted=1");
        else
            resp.sendRedirect("home?adopted=0");
    }
}
