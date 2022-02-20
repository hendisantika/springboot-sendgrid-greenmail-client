package com.hendisantika.service;

import com.hendisantika.client.SendGridClient;
import com.sendgrid.SendGrid;
import org.mockito.Mock;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 19.02
 * To change this template use File | Settings | File Templates.
 */
public class SendGridClientTest {
    private static final int STATUS_CODE = 205;
    private static final String HTML = "<!doctype html><html>"
            + "<body class=\"\"><table border=\"0\" cellpadding=\"0\" "
            + "cellspacing=\"0\" class=\"body\"></table></body></html>";

    private SendGridClient sendGridClient;
    @Mock
    private SendGrid sendGrid;

}
