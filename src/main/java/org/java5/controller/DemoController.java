package org.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/poly/hello")
    public String sayHello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "SpringBoot MVC");
        return "/demo/demo.html";
    }
}
