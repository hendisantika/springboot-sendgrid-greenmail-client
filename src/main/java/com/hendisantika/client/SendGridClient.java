package com.hendisantika.client;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.hendisantika.dto.RequestSendGridBuilder;
import com.hendisantika.exception.EmailConnectionException;
import com.hendisantika.service.EmailClientComponent;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

    @Override
    public EmailResponseDTO send(EmailRequestDTO request) throws EmailConnectionException {
        try {
            Request sendGridRequest = RequestSendGridBuilder.of()
                    .content(request.getContent())
                    .subject(request.getSubject())
                    .to(request.getTo())
                    .from(request.getFrom())
                    .key(sendGridKey)
                    .build();
            Response sendGridResponse = sendGrid.api(sendGridRequest);
            return getResponse(sendGridResponse, sendGridRequest);
        } catch (IOException e) {
            throw new EmailConnectionException(e);
        }
    }

    private EmailResponseDTO getResponse(Response response, Request request) {
        if (response.getBody().isEmpty()) {
            response.setBody(request.getBody());
        }
        return EmailResponseDTO.EmailResponseBuilder.of()
                .body(response.getBody())
                .headers(response.getHeaders())
                .statusCode(response.getStatusCode())
                .build();
    }
}
