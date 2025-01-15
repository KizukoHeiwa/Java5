package org.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/ctrl")
public class OkController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/ok")
    public String ok(@RequestParam("x") Optional<Integer> x) {
        String result = request.getMethod();
        if (x.isPresent()) {
            result += " với x = " + x.get();
        }
        request.setAttribute("result", result);
        return "/ok.html";
    }
}
