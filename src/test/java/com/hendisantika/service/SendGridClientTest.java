package com.hendisantika.service;

import com.hendisantika.client.SendGridClient;
import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sendGridClient = new SendGridClient(sendGrid, "sendGridKey");
    }

    @Test
    public void testReceiveEmailWhenResponseIsEmpty() throws Exception {
        Response responseSendGrid = new Response();
        when(sendGrid.api(Mockito.any(Request.class))).thenReturn(responseSendGrid);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        responseSendGrid.setHeaders(headers);
        responseSendGrid.setStatusCode(STATUS_CODE);
        responseSendGrid.setBody("");
        EmailResponseDTO responseEmail = sendGridClient.send(createRequestEmail());
        ArgumentCaptor<Request> requestCapture = ArgumentCaptor.forClass(Request.class);
        verify(sendGrid, atLeastOnce()).api(requestCapture.capture());
        Request request = requestCapture.getValue();
        assertThat(responseEmail.getBody()).isEqualTo(responseSendGrid.getBody());
        assertThat(responseEmail.getStatusCode()).isEqualTo(STATUS_CODE);
        assertThat(responseEmail.getHeaders()).containsKey("Content-Type");
        assertThat(request.getEndpoint()).isEqualTo("mail/send");
        assertThat(request.getMethod().toString()).isEqualTo("POST");
        assertThat(request.getBody()).isEqualTo("{\"from\":{\"email\":\"server@mail.com\"},"
                + "\"subject\":\"E-mail confirmation\",\"personalizations\":[{\"to\":[{\"email\":\"user.test@mail.com\"}]}],"
                + "\"content\":[{\"type\":\"text/html\",\"value\":\"Hello\"}],"
                + "\"custom_args\":{\"customerAccountNumber\":\"sendGridKey\"}}");
    }

    @Test
    public void testReceiveEmail() throws Exception {
        Response responseSendGrid = new Response();
        when(sendGrid.api(Mockito.any(Request.class))).thenReturn(responseSendGrid);
        responseSendGrid.setHeaders(Collections.singletonMap("Content-Type", "application/json"));
        responseSendGrid.setStatusCode(STATUS_CODE);
        responseSendGrid.setBody(HTML);
        EmailRequestDTO requestEmail = createRequestEmail();
        EmailResponseDTO responseEmail = sendGridClient.send(requestEmail);
        ArgumentCaptor<Request> requestCapture = ArgumentCaptor.forClass(Request.class);
        verify(sendGrid, atLeastOnce()).api(requestCapture.capture());
        Request request = requestCapture.getValue();
        assertThat(responseEmail.getBody()).isEqualTo(HTML);
        assertThat(responseEmail.getStatusCode()).isEqualTo(STATUS_CODE);
        assertThat(responseEmail.getHeaders().containsKey("Content-Type")).isTrue();
        assertThat(request.getEndpoint()).isEqualTo("mail/send");
        assertThat(request.getMethod().toString()).isEqualTo("POST");
        assertThat(request.getBody()).isEqualTo("{\"from\":{\"email\":\"server@mail.com\"},"
                + "\"subject\":\"E-mail confirmation\",\"personalizations\":[{\"to\":[{\"email\":\"user.test@mail.com\"}]}],"
                + "\"content\":[{\"type\":\"text/html\",\"value\":\"Hello\"}],"
                + "\"custom_args\":{\"customerAccountNumber\":\"sendGridKey\"}}");
    }
}
