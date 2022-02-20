package com.hendisantika.base;

import com.icegreen.greenmail.util.GreenMail;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 18.59
 * To change this template use File | Settings | File Templates.
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ContextConfiguration(classes = {FakeMailConfiguration.class})
public class EmailBaseIT {

    private static final String USER_PASSWORD = "Sendgrid@123";
    private static final String USER_NAME = "user.sendgrid";
    private static final String EMAIL_USER_ADDRESS = "greenmail@sendgrid.com";
    private static final int END_RANGE_EMAIL_PORT = 3555;
    private static final int INIT_RANGE_EMAIL_PORT = 3000;
    private static GreenMail greenMail;

    @LocalServerPort
    private int randomPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public EmailBaseIT(String contextPath) {
        this.contextPath = contextPath;
    }
}
