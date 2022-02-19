package com.hendisantika.validator;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.exception.InvalidEmailEntryException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.28
 * To change this template use File | Settings | File Templates.
 */
public interface EmailValidator {

    void validateEntry(EmailRequestDTO request) throws InvalidEmailEntryException;

}
