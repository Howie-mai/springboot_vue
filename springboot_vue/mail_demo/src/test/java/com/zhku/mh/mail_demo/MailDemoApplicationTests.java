package com.zhku.mh.mail_demo;

import com.zhku.mh.mail_demo.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
class MailDemoApplicationTests {
    @Autowired
    MailService mailService;

    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("193533653@qq.com",
                "494210688@qq.com",
                "494210688@qq.com",
                "点击领取男朋友",
                "恭喜你，通过真心获取男朋友一个，请亲一下身边的大宝贝领取，退订请回复，不给退订谢谢");
    }

    @Test
    public void testAttachMail() {
        mailService.sendAttachFileMail("193533653@qq.com",
                "494210688@qq.com",
                null,
                "这是一封带附件的邮件",
                "这是一封带附件的邮件",
                new File("D:\\1.jpg"), new File("D:\\12.png"));
    }

    @Test
    public void testHTMLMail() {
        mailService.sendHTMLMail("193533653@qq.com",
                "494210688@qq.com",
                null,
                "这是一封带图片的邮件",
                "<div>" +
                            "hello,这是一封带图片资源的邮件" +
                            "这是图片1：<div><img src='cid:img01'/></div>" +
                            "这是图片2：<div><img src='cid:img02'/></div>" +
                        "</div>",
                new String[]{"D:\\1.jpg", "D:\\12.png"},
                new String[]{"img01", "img02"});
    }

    @Test
    public void testThymeleafMail() {
        mailService.sendThymeleafMail("193533653@qq.com",
                "494210688@qq.com",
                null,
                "这是一封可以激活的邮件");
    }
}
