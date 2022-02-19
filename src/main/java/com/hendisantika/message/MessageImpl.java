package com.hendisantika.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<MessageInfo> mergeMessages(List<MessageInfo> messageList) {
        Map<String, MessageInfo> errorMap = new HashMap<>();
        for (MessageInfo serviceMessage : messageList) {
            String mergedKeyMessage = serviceMessage.getCode() + "-" + serviceMessage.getMessage();
            if (!errorMap.containsKey(mergedKeyMessage)) {
                errorMap.put(mergedKeyMessage, serviceMessage);
            }
        }
        return new ArrayList<>(errorMap.values());
    }

    @Override
    public String getOutputMessage(HttpStatus status) {
        StringBuilder strBuilder = new StringBuilder();
        if (status != null) {
            strBuilder
                    .append(status.value())
                    .append(" : ")
                    .append(get(String.valueOf(status.value())));
        }
        return strBuilder.toString();
    }
}
