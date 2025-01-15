package org.example.servlets;

import org.example.model.Category;
import org.example.model.Recipe;
import org.example.service.IngredientService;
import org.example.service.CategoryService;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "AddRecipeServlet", urlPatterns = {"/AddRecipe"})
public class AddRecipeServlet extends HttpServlet {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CategoryService categoryService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Добавить рецепт</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Добавить рецепт</h1>");
            out.println("<form method=\"post\" action='AddRecipe' target='_self'\">");
            out.println("<table>");
            out.println("<tbody>");
            out.println("<tr><th align=right>Название рецепта: ");
            out.println("<td><input type='text' name='title'></td></th></tr>");
            out.println("<tr><th align=right>Описание рецепта: ");
            out.println("<td><input type='text' name='description'></td></th></tr>");
            out.println("<tr><th align=right>Инструкция по приготовлению.: ");
            out.println("<td><input type='text' name='instructions'></td></th></tr>");
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

        System.out.println("AddRecipe POST");

        String title = request.getParameter("title");
        System.out.println(title);
        String description = request.getParameter("description");
        System.out.println(description);
        String instructions = request.getParameter("instructions");
        System.out.println(instructions);
        
        String newCatName = request.getParameter("catname");
        Category cat = categoryService.findByName(newCatName);

        Recipe rec = new Recipe (title, description, instructions, cat );

        recipeService.add(rec);
        response.sendRedirect("/index");
    }





}
