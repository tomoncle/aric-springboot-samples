package mail;

import com.aric.tomcat.mail.MailApplication;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
* @Time : 2017/12/17 11:13
* @Author : TOM.LEE
* @File : Test.java
 * 参考博客：http://blog.didispace.com/springbootmailsender/
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MailApplication.class)
public class TestSpringBootMail {

    //spring-boot-starter-mail 自动配置
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    final String ROOT_PATH = Class.class.getClass().getResource("/").getPath();

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test@qq.com");
        message.setTo("test-recv@qq.com");
        message.setSubject("主题：测试邮件");
        message.setText("hello world");
        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("test@qq.com");
        helper.setTo("test-recv@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File(ROOT_PATH+"mail/1.png"));
        helper.addAttachment("附件-1.png", file);
        helper.addAttachment("附件-2.png", file);

        mailSender.send(mimeMessage);

    }


    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("test@qq.com");
        helper.setTo("test-recv@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:file\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File(ROOT_PATH+"mail/1.png"));
        helper.addInline("file", file);

        mailSender.send(mimeMessage);

    }

    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("test@qq.com");
        helper.setTo("test-recv@qq.com");
        helper.setSubject("主题：模板邮件");

        Map<String,Object> model = new HashMap<>();
        model.put("username", "tom");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mail.vm", "UTF-8", model);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }
}
