package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.model.Ingredient;
import org.example.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IngredientServlet", urlPatterns = {"/ingredient"})
public class IngredientServlet extends HttpServlet{

    @Autowired
    private IngredientService ingredientService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ингридиенты</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Список ингридиентов</h1>");

            // Отображение ингридиентов в таблице
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr><th>ID</th><th>Название</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (Ingredient ingredient : ingredientService.listAll()) {
                out.println("<tr>");
                out.println("<td>" + ingredient.getIngredientId() + "</td>");
                out.println("<td>" + ingredient.getName() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("<hr>");
            out.println("<input type=\"button\" onclick=\"location.href='/index';\" value=\"Главная\" />");
        }
    }


}

