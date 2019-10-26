package com.zhku.mh.mail_demo.service.impl;

import com.zhku.mh.mail_demo.entities.User;
import com.zhku.mh.mail_demo.service.MailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    TemplateEngine templateEngine;

    @Override
    public void sendSimpleMail(String from, String to, String cc,
                               String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        if (StringUtils.isNoneBlank(cc)) {
            mailMessage.setCc(cc);
        }
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
    }

    @Override
    public void sendAttachFileMail(String from, String to, String cc,
                                   String subject, String content, File... file) {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            //构造一个带mutipart类型的文件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            if (StringUtils.isNoneBlank(cc)) {
                helper.setCc(cc);
            }
            helper.setSubject(subject);
            helper.setText(content);
            for (File data : file) {
                helper.addAttachment(data.getName(), data);
            }
            mailSender.send(mimeMailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendHTMLMail(String from, String to, String cc, String subject,
                             String content, String[] srcPath, String[] reIds) {
        if (srcPath.length != reIds.length) {
            System.out.println("发送失败");
            return;
        }
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            //构造一个带mutipart类型的文件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            if (StringUtils.isNoneBlank(cc)) {
                helper.setCc(cc);
            }
            helper.setSubject(subject);
            helper.setText(content, true);
            for (int i = 0; i < srcPath.length; i++) {
                FileSystemResource res = new FileSystemResource(new File(srcPath[i]));
                helper.addInline(reIds[i], res);
            }
            mailSender.send(mimeMailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendThymeleafMail(String from, String to, String cc,
                                  String subject) {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            //构造一个带mutipart类型的文件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            if (StringUtils.isNoneBlank(cc)) {
                helper.setCc(cc);
            }
            helper.setSubject(subject);
            //设置thymeleaf模板
            Context content = new Context();
            content.setVariable("username", "mh");
            content.setVariable("gender", "男");
            String text = templateEngine.process("mailtemplate.html", content);
            helper.setText(text, true);
            mailSender.send(mimeMailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
