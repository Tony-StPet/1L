package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.CategoryService;
import org.example.service.IngredientService;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "MainServlet", urlPatterns = {"/index"})
public class MainServlet extends HttpServlet {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private CategoryService categoryService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Рецепты</title>");
            out.println("</head>");
            out.println("<body>");

            // Таблица с рецептами
            out.println("<h1>Список Рецептов</h1>");
            out.println("<table border='1' style='border: 1px solid black; border-collapse: collapse;'>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<th>Название</th>");
            out.println("<th>Описание</th>");
            out.println("<th>Инструкции</th>");
            out.println("<th>Категория</th>");
            out.println("</tr>");
            for (org.example.model.Recipe recipe : recipeService.listAll()) {
                out.println("<tr>");
                out.println("<td>" + recipe.getTitle() + "</td>");
                out.println("<td>" + recipe.getDescription() + "</td>");
                out.println("<td>" + recipe.getInstructions() + "</td>");

                // Получаем категорию по ID
                String categoryName = categoryService.getCategoryNameById(recipe.getCategory().getCategoryId());
                out.println("<td>" + categoryName + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");

            // Кнопки для добавления новых рецептов, ингредиентов и категорий
            out.println("<hr>");
            out.println("<input type=\"button\" onclick=\"location.href='/AddRecipe';\" value=\"Добавить рецепт\" />");
            out.println("<input type=\"button\" onclick=\"location.href='/AddIngredient';\" value=\"Добавить ингредиент\" />");
            out.println("<input type=\"button\" onclick=\"location.href='/AddCategory';\" value=\"Добавить категорию\" />");
            out.println("<hr>");
            out.println("<br>");
            out.println("<input type=\"button\" onclick=\"location.href='/category';\" value=\"Категории\" />");
            out.println("<input type=\"button\" onclick=\"location.href='/ingredient';\" value=\"Ингридиенты\" />");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("/index GET");//debug
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
