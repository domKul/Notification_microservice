package com.dominik.notifications.service;

import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTests {

    @Autowired
    private EmailSenderImpl emailSender;

    @Test
    void shouldCreateAndSendEmail() throws MessagingException {
        emailSender.createAndSendEmail("dominik.kulpowicz@gmail.com","Test", "testestest");
    }
}
