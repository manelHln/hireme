package com.jobseeker.Jobseeker.services;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String fromMail;

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.mailSender = javaMailSender;
    }

    @Override
    public void sendMail(String to, String cc, String subject, String body, ArrayList<MultipartFile> files) {
        System.out.println(fromMail);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(fromMail);
            messageHelper.setTo(to);
            messageHelper.setCc(cc);
            messageHelper.setSubject(subject);
            messageHelper.setText(body);
            if(files != null && !files.isEmpty()){
                files.forEach(file-> {
                    try {
                        messageHelper.addAttachment(file.getOriginalFilename(), new ByteArrayResource(file.getBytes()));
                    } catch (MessagingException | IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
