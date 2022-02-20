package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.exception.TemplateException;
import com.hendisantika.validator.EmailValidator;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

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

    @Before
    public void init() throws TemplateException, IOException {
        MockitoAnnotations.initMocks(this);
        emailService = new EmailService(emailClientComponent
                , emailValidator
                , templateService);
        Mockito.when(templateService.parseTemplateParams(Mockito.any(EmailRequestDTO.class)))
                .thenReturn(TemplateServiceTest.getTemplateString("result-email-demo-template"));
    }
}
