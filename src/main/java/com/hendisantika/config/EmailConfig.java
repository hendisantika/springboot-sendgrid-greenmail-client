package com.hendisantika.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

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

    @Bean("sendGridService")
    public SendGrid getSendGridService() {
        return new SendGrid(sendGridKey);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
}
