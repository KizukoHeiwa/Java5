package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/login/form")
    public String form() {
        return "/demo/form.html";
    }

    @RequestMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("poly") && password.equals("123")) {
            model.addAttribute("message", "Đăng nhập thành công!");
        }
        else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
        }

        return "/demo/form.html";
    }
}
