package com.hendisantika.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
@ControllerAdvice
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(InvalidEmailEntryException.class)
    public ResponseEntity<OutputMessage> exceptionHandler(InvalidEmailEntryException ex) {
        logger.error(ex.getMessage(), ex);
        OutputMessage output = getStandardOutput(ex);
        output.setErrorList(ex.getListErros());
        return new ResponseEntity<>(output, ex.getStatus());
    }

    private OutputMessage getStandardOutput(InvalidEmailEntryException ex) {
        OutputMessage output = new OutputMessage();
        output.setStatusCode(ex.getStatus().value());
        output.setMessage(ex.getMessage());
        return output;
    }
}
