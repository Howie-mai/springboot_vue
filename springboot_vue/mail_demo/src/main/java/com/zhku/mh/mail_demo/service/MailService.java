package com.zhku.mh.mail_demo.service;

import com.zhku.mh.mail_demo.entities.User;

import java.io.File;

public interface MailService {
    /**
     * 简单发送邮件
     *
     * @param from    邮件发送者
     * @param to      收件人
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String from, String to, String cc,
                        String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param from    邮件发送者
     * @param to      收件人
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param file    文件
     */
    void sendAttachFileMail(String from, String to, String cc,
                            String subject, String content, File... file);

    /**
     * 发送带图片在文本的邮件
     *
     * @param from    邮件发送者
     * @param to      收件人
     * @param cc      抄送人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param srcPath 图片路径
     * @param reIds   图片ID
     */
    void sendHTMLMail(String from, String to, String cc,
                      String subject, String content, String[] srcPath, String[] reIds);

    /**
     * 发送thymeleaf模板的邮件
     *
     * @param from    邮件发送者
     * @param to      收件人
     * @param cc      抄送人
     * @param subject
     */
    void sendThymeleafMail(String from, String to, String cc,
                           String subject);
}
