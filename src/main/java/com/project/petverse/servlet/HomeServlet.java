package com.project.petverse.servlet;

import java.io.IOException;
import java.util.List;

import com.project.petverse.dao.PetDAO;
import com.project.petverse.model.Pet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PetDAO dao = new PetDAO();
        List<Pet> pets = dao.getAllPets();

        req.setAttribute("pets", pets);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
