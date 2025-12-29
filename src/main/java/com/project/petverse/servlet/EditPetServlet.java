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
 * EditPetServlet
 * ----------------------------------------------------------
 * Updates a pet's information.
 * ----------------------------------------------------------
 */

@WebServlet("/editPet")
public class EditPetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String type = request.getParameter("type");
        String breed = request.getParameter("breed");
        String desc = request.getParameter("description");
        String img = request.getParameter("imageUrl");

        Pet pet = new Pet(name, age, type, breed, desc, img);
        pet.setId(id);

        PetDAO dao = new PetDAO();
        boolean success = dao.updatePet(pet);

        if (success) {
            response.sendRedirect("home.jsp?updated=true");
        } else {
            response.sendRedirect("editPet.jsp?id=" + id + "&error=Failed");
        }
    }
}
