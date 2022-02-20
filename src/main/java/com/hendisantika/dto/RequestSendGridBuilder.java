package com.hendisantika.dto;

import com.sendgrid.*;
import lombok.Data;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.18
 * To change this template use File | Settings | File Templates.
 */
@Data
public class RequestSendGridBuilder {
    private static final String MIME_TYPE_HTML = "text/html";
    private static final String ENDPOINT_MAIL_SEND = "mail/send";
    private Mail mail = new Mail();
    private Content content = new Content();

    public static RequestSendGridBuilder of() {
        return new RequestSendGridBuilder();
    }

    public RequestSendGridBuilder from(String from) {
        mail.setFrom(new Email(from));
        return this;
    }

    public RequestSendGridBuilder key(String key) {
        mail.addCustomArg("customerAccountNumber", key);
        return this;
    }

    public RequestSendGridBuilder content(String template) {
        content.setType(MIME_TYPE_HTML);
        content.setValue(template);
        return this;
    }

    public RequestSendGridBuilder subject(String subject) {
        mail.setSubject(subject);
        return this;
    }

    public RequestSendGridBuilder to(String to) {
        Personalization personalization = new Personalization();
        personalization.addTo(new Email(to));
        mail.addPersonalization(personalization);
        return this;
    }

    public Request build() throws IOException {
        mail.addContent(content);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint(ENDPOINT_MAIL_SEND);
        request.setBody(mail.build());
        return request;
    }
}
