package com.example.helloweb.modelmvc2;

import com.example.helloweb.domain.Product;
import com.example.helloweb.domain.ProductForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        ProductForm productForm = new ProductForm();
        productForm.setName(request.getParameter("name"));
        productForm.setDescription(request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));

        ProductValidator validator = new ProductValidator();
        List<String> errors = validator.validate(productForm);
        if (errors.isEmpty()) {
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));
            request.setAttribute("product", product);
            return "/jsp/ProductDetails.jsp";
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("form", productForm);
            return "/jsp/ProductForm.jsp";
        }

    }
}
