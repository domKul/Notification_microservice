package com.dominik.notifications.service;

import com.dominik.notifications.dto.EmailDto;
import com.dominik.notifications.dto.NotificationInfoDto;
import jakarta.mail.MessagingException;

public interface EmailSender {

    void sendEmails(NotificationInfoDto notificationInfoDto);

    void sendEmail(EmailDto emailDto) throws MessagingException;


}
