package com.dominik.notifications.service;

import com.dominik.notifications.dto.NotificationInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqListener {

    private final EmailSender emailSender;
    private final Logger LOGGER =  LoggerFactory.getLogger(RabbitmqListener.class);

    public RabbitmqListener(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @RabbitListener(queues = "enroll_finish")
    public void handleFinishEnroll(NotificationInfoDto notificationInfo) {
        LOGGER.info("sending emails");
        emailSender.sendEmails(notificationInfo);

    }
}
