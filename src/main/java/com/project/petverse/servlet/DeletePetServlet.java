package com.project.petverse.servlet;

import java.io.IOException;

import com.project.petverse.dao.PetDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * DeletePetServlet
 * ----------------------------------------------------------
 * Deletes a pet from database using its ID.
 * ----------------------------------------------------------
 */

@WebServlet("/deletePet")
public class DeletePetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        PetDAO dao = new PetDAO();

        dao.deletePet(id);

        response.sendRedirect("home.jsp?deleted=true");
    }
}
