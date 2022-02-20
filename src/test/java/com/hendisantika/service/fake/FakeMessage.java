package com.hendisantika.service.fake;

import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 19.09
 * To change this template use File | Settings | File Templates.
 */
@Data
public class FakeMessage {
    private List<String> recipients;
    private String content;
    private List<String> from;
    private String subject;

    public static final class FakeMessageBuilder {
        private final FakeMessage fakeMessage;

        private FakeMessageBuilder() {
            fakeMessage = new FakeMessage();
        }

        public static FakeMessageBuilder of() {
            return new FakeMessageBuilder();
        }

        public FakeMessageBuilder recipients(List<String> recipients) {
            fakeMessage.setRecipients(recipients);
            return this;
        }

        public FakeMessageBuilder content(String content) {
            fakeMessage.setContent(content);
            return this;
        }

        public FakeMessageBuilder from(List<String> from) {
            fakeMessage.setFrom(from);
            return this;
        }

        public FakeMessageBuilder subject(String subject) {
            fakeMessage.setSubject(subject);
            return this;
        }

        public FakeMessage build() {
            return fakeMessage;
        }
    }
}
