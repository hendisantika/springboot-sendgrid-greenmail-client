package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.15
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {
    @NotEmpty(message = "INVALID_MAIL_TO")
    private String to;
    @NotEmpty(message = "INVALID_MAIL_FROM")
    private String from;
    @NotEmpty(message = "INVALID_MAIL_SUBJECT")
    private String subject;
    @NotEmpty(message = "INVALID_MAIL_TEMPLATE_NAME")
    private String templateName;
    private String content;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private Map<String, String> templateParams = new HashMap<>();

    public static final class EmailRequestBuilder {
        private final EmailRequestDTO emailRequest;

        private EmailRequestBuilder() {
            emailRequest = new EmailRequestDTO();
        }

        public static EmailRequestBuilder of() {
            return new EmailRequestBuilder();
        }

        public EmailRequestBuilder to(String to) {
            emailRequest.setTo(to);
            return this;
        }

        public EmailRequestBuilder from(String from) {
            emailRequest.setFrom(from);
            return this;
        }

        public EmailRequestBuilder subject(String subject) {
            emailRequest.setSubject(subject);
            return this;
        }

        public EmailRequestBuilder content(String content) {
            emailRequest.setContent(content);
            return this;
        }

        public EmailRequestBuilder templateName(String templateName) {
            emailRequest.setTemplateName(templateName);
            return this;
        }

        public EmailRequestBuilder headers(Map<String, String> headers) {
            emailRequest.setHeaders(headers);
            return this;
        }

        public EmailRequestBuilder queryParams(Map<String, String> queryParams) {
            emailRequest.setQueryParams(queryParams);
            return this;
        }

        public EmailRequestBuilder templateParams(Map<String, String> templateParams) {
            emailRequest.setTemplateParams(templateParams);
            return this;
        }

        public EmailRequestDTO build() {
            return emailRequest;
        }
    }
}
