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

}
