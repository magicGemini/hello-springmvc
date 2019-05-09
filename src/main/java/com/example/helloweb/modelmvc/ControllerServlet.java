package com.example.helloweb.modelmvc;

import com.example.helloweb.domain.Product;
import com.example.helloweb.domain.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(name = "ControllerServlet", urlPatterns = {"/product_input.action","/product_save.action"})
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        if(action.equals("product_input.action")){

            // no service need to do
        }else if(action.equals("product_save.action")){

            //1. get parameter
            ProductForm productForm = new ProductForm();
            productForm.setName(req.getParameter("name"));
            productForm.setDescription(req.getParameter("description"));
            productForm.setPrice(req.getParameter("price"));

            //2. TODO: validation

            //3. TODO: save database

            //4. reform data
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try{
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            }catch (NumberFormatException e) {
                // TODO: handle exception
            }
            req.setAttribute("product", product);
        }

        //5. direct to view
        String dispatchUrl = null;
        if(action.equals("product_input.action")){
            dispatchUrl = "/jsp/ProductForm.jsp";
        }else if(action.equals("product_save.action")){
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }
        if(dispatchUrl != null){
            RequestDispatcher rd = req.getRequestDispatcher(dispatchUrl);
            rd.forward(req, resp);
        }
    }
}
