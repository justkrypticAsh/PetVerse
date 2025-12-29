package com.project.petverse.servlet;

import java.io.IOException;

import com.project.petverse.dao.PetDAO;
import com.project.petverse.model.Pet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AddPetServlet
 * ----------------------------------------------------------
 * Adds a new pet into the database.
 * ----------------------------------------------------------
 */

@WebServlet("/addPet")
public class AddPetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String type = request.getParameter("type");
        String breed = request.getParameter("breed");
        String desc = request.getParameter("description");
        String img = request.getParameter("imageUrl");

        Pet pet = new Pet(name, age, type, breed, desc, img);
        PetDAO dao = new PetDAO();

        boolean success = dao.addPet(pet);

        if (success) {
            response.sendRedirect("home.jsp?added=true");
        } else {
            response.sendRedirect("addPet.jsp?error=Failed");
        }
    }
}
