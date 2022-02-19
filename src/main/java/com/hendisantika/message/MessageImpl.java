package com.hendisantika.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

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


}
