package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.hendisantika.exception.EmailConnectionException;
import com.hendisantika.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 07.01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final EmailClientComponent emailClientComponent;
    private final TemplateService templateService;

    public EmailService(EmailClientComponent emailClientComponent, EmailValidator emailValidatorImpl, TemplateService templateService) {
        this.emailClientComponent = emailClientComponent;
        this.templateService = templateService;
    }

    public EmailResponseDTO sendMail(EmailRequestDTO email) throws Exception {
        try {
            String parsedTemplate = templateService.parseTemplateParams(email);
            EmailRequestDTO request = EmailRequestDTO.EmailRequestBuilder.of()
                    .content(parsedTemplate)
                    .from(email.getFrom())
                    .to(email.getTo())
                    .subject(email.getSubject())
                    .templateName(email.getTemplateName())
                    .build();
            EmailResponseDTO response = emailClientComponent.send(request);
            return response;
        } catch (EmailConnectionException e) {
            LOGGER.error("Error on send email process", e);
            throw e;
        }
    }
}
