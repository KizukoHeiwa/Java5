package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Calculate {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/calculate/form")
    public String form() {
        return "/demo/tinhToan.html";
    }

    @RequestMapping("/calculate/result")
    public String login(Model model) {
        String chieuDai = request.getParameter("chieuDai");
        String chieuRong = request.getParameter("chieuRong");

        model.addAttribute("chuVi", (Integer.parseInt(chieuDai) + Integer.parseInt(chieuRong)) * 2);
        model.addAttribute("dienTich", Integer.parseInt(chieuDai) * Integer.parseInt(chieuRong));

        return "/demo/tinhToan.html";
    }
}
