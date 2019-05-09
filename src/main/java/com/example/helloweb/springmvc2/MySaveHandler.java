package com.example.helloweb.springmvc2;

import com.example.helloweb.domain.Product;
import com.example.helloweb.domain.ProductForm;
import com.example.helloweb.modelmvc2.ProductValidator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MySaveHandler implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

            return new ModelAndView("ProductDetails", "product", product);
        } else {
            ModelAndView modelAndView = new ModelAndView("ProductForm");
            modelAndView.addObject("errors", errors);
            modelAndView.addObject("form", productForm);
            return modelAndView;
        }
    }

}
