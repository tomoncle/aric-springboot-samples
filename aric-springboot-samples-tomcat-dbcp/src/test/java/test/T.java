package test;

import aric.springboot.config.mail.SmtpMailSender;
import com.aric.tomcat.dbcp.JavaApplication;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time : 2017/12/3 22:43
 * @Author : TOM.LEE
 * @File : T.java
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JavaApplication.class)
public class T {

    @Autowired
    private SmtpMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void send() {
        Map<String, Object> model = new HashMap<>();
        model.put("username", "tom");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "mail.vm", "UTF-8", model);
        mailSender.sendTextMail("recv@qq.com", "test", text);
    }


}
