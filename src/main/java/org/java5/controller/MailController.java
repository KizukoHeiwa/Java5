package org.java5.controller;

import jakarta.mail.MessagingException;
import org.java5.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("mail")
public class MailController {
    @Autowired
    MailService mailService;

    @RequestMapping("index")
    public String index(Model model) {
        return "mail/index";
    }

    @ResponseBody
    @RequestMapping("/mail/send")
    public String send() {
        mailService.send("receiver@gmail.com", "Subject", "Body");
        return "Mail của bạn đã được gửi đi";
    }


    @ResponseBody
    @RequestMapping("/queue")
    public String send(Model model) {
        mailService.push("receiver@gmail.com", "Subject", "Body");
        return "Mail của bạn đã được xếp vào hàng đợi";
    }
}
