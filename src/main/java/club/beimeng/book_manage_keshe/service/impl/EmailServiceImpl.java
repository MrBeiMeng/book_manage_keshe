package club.beimeng.book_manage_keshe.service.impl;

import club.beimeng.book_manage_keshe.entity.VerifyCode;
import club.beimeng.book_manage_keshe.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 使用java 优雅的发送邮件
     * @param from 发件人
     * @param to 收件人
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    public void sendSimpleMail(String from, String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发件人
        simpleMailMessage.setFrom(from);
        // 收件人
        simpleMailMessage.setTo(to);
        // 邮件主题
        simpleMailMessage.setSubject(subject);
        // 邮件内容
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }

}
