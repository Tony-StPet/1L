package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    @Autowired
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Категории</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Список категорий</h1>");
//            out.println(categoryService.listAll());

            // Отображение категорий в таблице
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr><th>ID</th><th>Название</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (Category category : categoryService.listAll()) {
                out.println("<tr>");
                out.println("<td>" + category.getCategoryId() + "</td>");
                out.println("<td>" + category.getName() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("<hr>");
            out.println("<input type=\"button\" onclick=\"location.href='/index';\" value=\"Главная\" />");
        }
    }


}
