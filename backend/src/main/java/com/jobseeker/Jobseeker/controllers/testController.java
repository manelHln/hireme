package com.jobseeker.Jobseeker.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseeker.Jobseeker.services.EmailServiceImpl;

@RestController
@RequestMapping("test")
public class testController {

    private final EmailServiceImpl mailService;

    public testController(EmailServiceImpl emailServiceImpl) {
        this.mailService = emailServiceImpl;
    }
    
    @GetMapping
    public String helloController() {
        mailService.sendMail("holonouemmanuel0@gmail.com", "emmanuelholonou.pro@gmail.com", "Test mail sending spring boot", "This is a sample message to confirm that mail sending is working across the spring boot hireme application", null);
        return "Hello world!";
    }
}
