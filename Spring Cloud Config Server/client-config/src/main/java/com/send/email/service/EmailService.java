package com.send.email.service;

public interface EmailService {
    void sendEmail(String myEmail, String toEmail, String subject, String body);
}
