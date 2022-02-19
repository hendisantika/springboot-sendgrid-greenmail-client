package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/02/22
 * Time: 19.22
 * To change this template use File | Settings | File Templates.
 */
public class TemplateException extends Exception {

    private static final long serialVersionUID = 1L;

    public TemplateException(String code) {
        super(code);
    }

    public TemplateException(String code, Throwable cause) {
        super(code, cause);
    }
}
