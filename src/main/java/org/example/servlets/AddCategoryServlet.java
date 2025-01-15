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

@WebServlet(name = "AddCategoryServlet", urlPatterns = {"/AddCategory"})

public class AddCategoryServlet extends HttpServlet {

    @Autowired
    private CategoryService categoryService;
    protected void processRequest (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Добавить категорию</title>");
            out.println("</head>");
            out.println("<body>");

            // Форма для добавления новой категории
            out.println("<h2>Добавить новую категорию</h2>");
            out.println("<form method=\"post\" action='AddCategory' target='_self'\">");
            out.println("<table>");
            out.println("<tbody>");
            out.println("<tr><th align=right>Категория: ");
            out.println("<td><input type='text' name='category_name'></td></th></tr>");
            out.println("</tbody>");
            out.println("</table>");

            out.println("<input id=\"button\" type=submit value=\"Добавить\" style=\"padding: 5px 15px;\">");
//            out.println("<input id=\"button\" type=submit\" value=\"Добавить\">");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("AddCategory POST");

        String name = req.getParameter("category_name");

        System.out.println(name);

        categoryService.add(name);

//        String newCatName = req.getParameter("catname");
//        System.out.println(newCatName);
//        Category newCat = new Category(newCatName);
 //       categoryService.add(newCatName);
//        categoryService.add(newCatName);
//
        resp.sendRedirect("/index");
    }
}
