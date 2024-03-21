package org.baileyseye.servlets;

import org.baileyseye.product.ProductManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "AddProductServlet")

public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productName = req.getParameter("productName");
        try {
            int productPrice = Integer.parseInt(req.getParameter("productPrice"));
            ProductManager.insertProduct(productName, productPrice);
            resp.sendRedirect("products");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Price must be a number.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addProduct/index.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to add product");
        }
    }
}
