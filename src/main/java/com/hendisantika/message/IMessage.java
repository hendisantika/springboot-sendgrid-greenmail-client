package com.hendisantika.message;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.23
 * To change this template use File | Settings | File Templates.
 */
@Component
public interface IMessage {

    String getMessage(String key);

    MessageInfo getMessageInfo(String key);

    List<MessageInfo> mergeMessages(final List<MessageInfo> messageList);

    String getOutputMessage(HttpStatus status);
}
