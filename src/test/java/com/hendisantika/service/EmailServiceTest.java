package com.hendisantika.service;

import com.hendisantika.validator.EmailValidator;
import org.mockito.Mock;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 19.01
 * To change this template use File | Settings | File Templates.
 */
public class EmailServiceTest {
    private EmailService emailService;

    @Mock
    private EmailClientComponent emailClientComponent;

    @Mock
    private TemplateService templateService;

    @Mock
    private EmailValidator emailValidator;
}
