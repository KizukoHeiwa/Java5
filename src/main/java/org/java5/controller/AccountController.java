package org.java5.controller;

import org.java5.service.CookieService;
import org.java5.service.ParamService;
import org.java5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "/account/login";
    }
    @PostMapping("/account/login")
    public String login2() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("admin") && password.equals("123")) {
            sessionService.set("username", username);

            if (remember) {
                cookieService.add("username", username, 240);
            }
            else {
                cookieService.remove("username");
            }
            return "redirect:/";
        }

        return "/account/login";
    }

    @GetMapping("/account/logout")
    public String logout() {
        sessionService.remove("username");
        cookieService.remove("username");
        return "redirect:/";
    }
}

