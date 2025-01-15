package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.java5.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product2")
public class ProductController2 {

    List<Product> listItems = new ArrayList<>(List.of(
            new Product("A", 1.0),
            new Product("B", 12.0))
    );

    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("product", p);
        return "productForm2.html";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p) {
        listItems.add(p);
        return "productForm2.html";
    }
    @ModelAttribute("items")
    public List<Product> getItems() {
        return listItems;
    }
}


