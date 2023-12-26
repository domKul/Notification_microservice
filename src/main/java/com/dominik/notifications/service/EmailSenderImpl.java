package com.dominik.notifications.service;

import com.dominik.notifications.dto.EmailDto;
import com.dominik.notifications.dto.NotificationInfoDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;

    public EmailSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmails(NotificationInfoDto notificationInfoDto) {
      String title = "Pamietaj o kursie: " + notificationInfoDto.getCourseName();
        StringBuilder content = createContent(notificationInfoDto);
        createEmailContent result = new createEmailContent(title, content);
        notificationInfoDto.getEmails().forEach(email-> {
          try {
              createAndSendEmail(email, result.title(), result.content().toString());
          } catch (MessagingException e) {
              throw new RuntimeException(e);
          }
      });


    }

    private static StringBuilder createContent(NotificationInfoDto notificationInfoDto) {
        StringBuilder content = new StringBuilder();
        content.append("Kurs: ");
        content.append(notificationInfoDto.getCourseName());
        content.append(" rozpoczyna sie: ");
        content.append(notificationInfoDto.getCourseStartDate().toLocalDate());
        content.append(" o godzinie: ");
        content.append(notificationInfoDto.getCourseStartDate().getHour()).append(":").append(notificationInfoDto.getCourseStartDate().getMinute());
        content.append("\n");
        content.append("Opis kursu:");
        content.append(notificationInfoDto.getCourseDescription());
        content.append("\n");
        content.append("Kurs konczy sie ");
        content.append(notificationInfoDto.getCourseEndDate().getHour()).append(":").append(notificationInfoDto.getCourseEndDate().getMinute());
        return content;
    }

    private record createEmailContent(String title, StringBuilder content) {
    }

    @Override
    public void sendEmail(EmailDto emailDto) throws MessagingException {
        createAndSendEmail(emailDto.to(), emailDto.title(), emailDto.content());
    }

    void createAndSendEmail(String to, String title, String content) throws MessagingException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(content,false);
        javaMailSender.send(mimeMailMessage);
    }
}
