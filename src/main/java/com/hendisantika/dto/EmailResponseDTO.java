package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.17
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponseDTO {
    private int statusCode;
    private String body;
    private Map<String, String> headers;

    public static final class EmailResponseBuilder {
        private final EmailResponseDTO emailResponse;

        private EmailResponseBuilder() {
            emailResponse = new EmailResponseDTO();
        }

        public static EmailResponseBuilder of() {
            return new EmailResponseBuilder();
        }

        public EmailResponseBuilder statusCode(int statusCode) {
            emailResponse.setStatusCode(statusCode);
            return this;
        }

        public EmailResponseBuilder body(String body) {
            emailResponse.setBody(body);
            return this;
        }

        public EmailResponseBuilder headers(Map<String, String> headers) {
            emailResponse.setHeaders(headers);
            return this;
        }

        public EmailResponseDTO build() {
            return emailResponse;
        }
    }
}
