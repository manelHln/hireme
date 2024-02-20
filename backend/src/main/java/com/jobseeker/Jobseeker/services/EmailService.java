package com.jobseeker.Jobseeker.services;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    public void sendMail(String to, String cc, String subject, String body, ArrayList<MultipartFile> files);
}
