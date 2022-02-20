package com.hendisantika.controller;

import com.hendisantika.base.EmailBaseIT;
import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.service.fake.FakeEmailServer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/02/22
 * Time: 06.21
 * To change this template use File | Settings | File Templates.
 */
public class EmailSendgridControllerIT extends EmailBaseIT {

    @Autowired
    private FakeEmailServer fakeEmailServer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSendMailThenVerifyInbox() throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        Map<String, String> queryParams = new HashMap<>();

        Map<String, String> templateParams = new HashMap<>();
        templateParams.put("name", "User Test");
        templateParams.put("email", "user.test@mail.com");

        EmailRequestDTO requestEmail = EmailRequestDTO.EmailRequestBuilder.of()
                .to("user.test@mail.com")
                .from("server@mail.com")
                .content("content")
                .headers(headers)
                .queryParams(queryParams)
                .templateName("email-demo-template")
                .templateParams(templateParams)
                .subject("E-mail Confirmation")
                .build();
        fakeEmailServer.send(requestEmail);
        Assertions.assertThat(fakeEmailServer.getInbox().size()).isEqualTo(1);
    }
}
