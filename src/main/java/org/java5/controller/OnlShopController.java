package org.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class OnlShopController {
    @RequestMapping("/index")
    public String index(Model model) {
        return "/home/home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "/home/about";
    }

}
