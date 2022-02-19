package com.hendisantika.exception;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.21
 * To change this template use File | Settings | File Templates.
 */
public class EmailConnectionException extends IOException {

    private static final long serialVersionUID = 1L;

    public EmailConnectionException(Exception e) {
        super(e);
    }
}
