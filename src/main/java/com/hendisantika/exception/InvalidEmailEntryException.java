package com.hendisantika.exception;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

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
public class InvalidEmailEntryException extends Exception {

    private static final long serialVersionUID = 1L;
    private final List<MessageInfo> listErros = new ArrayList<>();
    private HttpStatus httpStatus;

    public InvalidEmailEntryException(final List<MessageInfo> listErros, final String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
        addErrors(listErros);
    }

    public List<MessageInfo> getListErros() {
        return listErros;
    }

    public void addErrors(final List<MessageInfo> errors) {
        listErros.addAll(errors);
    }

    public void addError(final MessageInfo error) {
        listErros.add(error);
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    public void setStatus(HttpStatus status) {
        this.httpStatus = status;
    }
}
