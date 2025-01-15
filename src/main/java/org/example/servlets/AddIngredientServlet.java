package org.example.servlets;

import org.example.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddIngredientServlet", urlPatterns = {"/AddIngredient"})

public class AddIngredientServlet extends HttpServlet {
    @Autowired
    private IngredientService ingredientService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Добавить ингредиент</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Добавить ингредиент</h1>");
            out.println("<form method=\"post\" action='AddIngredient' target='_self'\">");
            out.println("<table>");
            out.println("<tbody>");
            out.println("<tr><th align=right>Ингредиент: ");
            out.println("<td><input type='text' name='name'></td></th></tr>");
            out.println("</tbody>");
            out.println("</table>");

            out.println("<input id=\"button\" type=submit value=\"Добавить\" style=\"padding: 5px 15px;\">");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("AddIngredient POST");

        String name = request.getParameter("name");

        System.out.println(name);

        ingredientService.add(name);
        response.sendRedirect("/index");
    }

}