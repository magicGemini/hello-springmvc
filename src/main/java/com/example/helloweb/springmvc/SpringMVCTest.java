package com.example.helloweb.springmvc;

import com.example.helloweb.domain.Product;
import com.example.helloweb.domain.ProductForm;
import com.example.helloweb.modelmvc2.ProductValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SpringMVCTest {

    @RequestMapping("/product_input.action")
    public String tc1_input() {
        return "/jsp/ProductForm.jsp";
    }

    @RequestMapping("/product_save.action")
    public String tc1_save(@RequestParam String name, @RequestParam String description, @RequestParam String price, Model model) {

        ProductForm productForm = new ProductForm();
        productForm.setName(name);
        productForm.setDescription(description);
        productForm.setPrice(price);

        ProductValidator validator = new ProductValidator();
        List<String> errors = validator.validate(productForm);
        if (errors.isEmpty()) {
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            product.setPrice(Float.parseFloat(productForm.getPrice()));

            model.addAttribute("product", product);
            return "/jsp/ProductDetails.jsp";
        } else {
            model.addAttribute("errors", errors);
            model.addAttribute("form", productForm);
            return "/jsp/ProductForm.jsp";
        }
    }

}