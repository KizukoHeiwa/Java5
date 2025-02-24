package org.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    @RequestMapping("/account/edit-profile")
    public String editProfile() {
        return "account/edit-profile";
    }
    @RequestMapping("/account/change-password")
    public String changePassword() {
        return "account/change-password";
    }
}
