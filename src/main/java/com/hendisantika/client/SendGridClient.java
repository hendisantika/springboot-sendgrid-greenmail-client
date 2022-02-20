package com.hendisantika.client;

import com.hendisantika.service.EmailClientComponent;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 18.54
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SendGridClient implements EmailClientComponent {

    private final SendGrid sendGrid;
    private final String sendGridKey;

    public SendGridClient(SendGrid sendGrid, @Value("${sendgrid.key}") String sendGridKey) {
        this.sendGrid = sendGrid;
        this.sendGridKey = sendGridKey;
    }
}
