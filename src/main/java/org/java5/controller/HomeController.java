package org.java5.controller;

import org.java5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    SessionService sessionService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("username", sessionService.get("username"));
        return "index";
    }
}
