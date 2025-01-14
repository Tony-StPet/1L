package org.example.servlets;

import org.example.service.CategoryService;
import org.example.service.IngredientService;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                    String categoryName = categoryService.getCategoryNameById(recipe.getCategoryId());
                    out.println("<td>" + categoryName + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");

                // Кнопки для добавления новых рецептов, ингредиентов и категорий
                out.println("<hr>");
                out.println("<input type=\"button\" onclick=\"location.href='http://127.0.0.1:8080/AddRecipe';\" value=\"Добавить рецепт\" />");
                out.println("<input type=\"button\" onclick=\"location.href='http://127.0.0.1:8080/AddIngredient';\" value=\"Добавить ингредиент\" />");
                out.println("<input type=\"button\" onclick=\"location.href='http://127.0.0.1:8080/AddCategory';\" value=\"Добавить категорию\" />");
                out.println("</body>");
                out.println("</html>");
            }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

    }
