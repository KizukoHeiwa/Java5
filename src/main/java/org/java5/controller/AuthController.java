package org.java5.controller;

import org.java5.entities.Account;
import org.java5.service.AccountService;
import org.java5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    AccountService accountService;
    @Autowired
    SessionService session;

    @GetMapping("/auth/login")
    public String loginForm(Model model) {
        return "/auth/login";
    }

    @PostMapping("/auth/login")
    public String loginProcess(Model model,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password) {
        Account user = accountService.findById(username);
        if (user == null) {
            model.addAttribute("message", "Invalid username!");
        } else if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "Invalid password!");
        } else {
            session.set("user", user);
            model.addAttribute("message", "Login successfully!");
            String securityUri = session.get("securityUri");
            if (securityUri != null) {
                return "redirect:" + securityUri;
            }
            return "redirect:/";
        }

        return "/auth/login";
    }

    @GetMapping("/auth/logout")
    public String logout() {
        session.remove("user");
        return "redirect:/";
    }
}

