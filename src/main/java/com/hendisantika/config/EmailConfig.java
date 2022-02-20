package com.hendisantika.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 18.52
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class EmailConfig {

    @Value("${sendgrid.key}")
    private String sendGridKey;
}
