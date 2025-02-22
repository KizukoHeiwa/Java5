package org.java5.controller;

import org.java5.service.MailService;
import org.java5.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("mail")
public class MailController {
    @Autowired
    MailService mailService;
    @Autowired
    ParamService paramService;

    @RequestMapping("index")
    public String index() {
        return "mail/index";
    }

    @ResponseBody
    @RequestMapping("/send")
    public String send(@RequestParam("filenames") MultipartFile[] filenames) {
        String from = paramService.getString("from", "");
        String to = paramService.getString("to", "");
        String cc = paramService.getString("cc", "");
        String bcc = paramService.getString("bcc", "");
        String subject = paramService.getString("subject", "");
        String body = paramService.getString("body", "");

//        String filenames = paramService.getString("filenames", "");
//        mailService.send("receiver@gmail.com", "Subject", "Body");

        mailService.send(from, to, cc, bcc, subject, body, filenames);
        return "Mail của bạn đã được gửi đi";
    }


    @ResponseBody
    @RequestMapping("/queue")
    public String queue(@RequestParam("filenames") MultipartFile[] filenames) {
        String from = paramService.getString("from", "");
        String to = paramService.getString("to", "");
        String cc = paramService.getString("cc", "");
        String bcc = paramService.getString("bcc", "");
        String subject = paramService.getString("subject", "");
        String body = paramService.getString("body", "");

//        String filenames = paramService.getString("filenames", "");
//        mailService.push("receiver@gmail.com", "Subject", "Body");

        mailService.push(from, to, cc, bcc, subject, body, filenames);
        return "Mail của bạn đã được xếp vào hàng đợi";
    }
}
