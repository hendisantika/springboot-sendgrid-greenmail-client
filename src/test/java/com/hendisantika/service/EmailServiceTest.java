package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.hendisantika.exception.TemplateException;
import com.hendisantika.validator.EmailValidator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Collections;

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

    @Test
    public void whenCallClientThenSendEmail() throws Exception {
        EmailRequestDTO email = EmailRequestDTO.EmailRequestBuilder.of()
                .to("john@company.com")
                .build();
        Mockito.when(emailClientComponent.send(Mockito.any(EmailRequestDTO.class))).thenReturn(
                EmailResponseDTO.EmailResponseBuilder.of()
                        .headers(Collections.singletonMap("a", "b"))
                        .body("456")
                        .build());
        EmailResponseDTO response = emailService.sendMail(email);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getHeaders()).isEqualTo(Collections.singletonMap("a", "b"));
        Assertions.assertThat(response.getStatusCode()).isEqualTo(0);
        Assertions.assertThat(response.getBody()).isEqualTo("456");
        Mockito.verify(templateService).parseTemplateParams(email);
    }
}
