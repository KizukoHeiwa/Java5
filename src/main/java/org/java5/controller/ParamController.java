package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/param/form")
    public String form() {
        return "/form.html";
    }

    @RequestMapping("/param/save/{x}")
    public String save(@PathVariable("x") String x, @RequestParam("y") String y) {

        request.setAttribute("x", x);
        request.setAttribute("y", y);

        return "/form.html";
    }
}

