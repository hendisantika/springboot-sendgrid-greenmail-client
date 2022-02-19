package com.hendisantika.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.26
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MessageImpl implements IMessage {

    @Autowired
    private MessageSource messageSource;

    private String get(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    @Override
    public String getMessage(String key) {
        return get(key);
    }

    @Override
    public MessageInfo getMessageInfo(String key) {
        return new MessageInfo(key, get(key));
    }
}
