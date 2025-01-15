package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.java5.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/form")
    public String form() {
        return "productForm.html";
    }

    @PostMapping("/save")
    public String save(Product bean) {
        request.setAttribute("name", bean.getName());
        request.setAttribute("price", bean.getPrice());
        return "productForm.html";
    }
}

