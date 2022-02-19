package com.hendisantika.validator;

import com.hendisantika.message.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.29
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailValidatorImpl implements EmailValidator {

    @Autowired
    private IMessage serviceMessage;
}
