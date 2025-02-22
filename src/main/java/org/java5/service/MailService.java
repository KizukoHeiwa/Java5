package org.java5.service;

import lombok.Builder;
import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartFile;

@EnableScheduling
public interface MailService{
    @Data
    @Builder
    public static class Mail{
        @Builder.Default
        private String from = "WebShop <web-shop@gmail.com>";
        private String to, cc, bcc, subject, body;
        private MultipartFile[] filenames;
    }

    void send(Mail mail);
    default void send(String from, String to, String cc, String bcc, String subject, String body, MultipartFile[] filenames){
//        Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
        Mail mail = Mail.builder().from(from).to(to).cc(cc).bcc(bcc).subject(subject).body(body).filenames(filenames).build();
        this.send(mail);
    }


    void push(Mail mail);
    default void push(String from, String to, String cc, String bcc, String subject, String body, MultipartFile[] filenames){
//        this.push(Mail.builder().to(to).subject(subject).body(body).build());
        Mail mail = Mail.builder().from(from).to(to).cc(cc).bcc(bcc).subject(subject).body(body).filenames(filenames).build();
        this.push(mail);
    }

}

