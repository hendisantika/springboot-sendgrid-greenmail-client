package com.hendisantika.validator;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.exception.InvalidEmailEntryException;
import com.hendisantika.message.IMessage;
import com.hendisantika.message.MessageInfo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public void validateEntry(final EmailRequestDTO request) throws InvalidEmailEntryException {
        List<MessageInfo> messages = new ArrayList<>();
        validateRequiredFields(request, messages, this.serviceMessage);
        if (!messages.isEmpty()) {
            throw new InvalidEmailEntryException(serviceMessage.mergeMessages(messages),
                    this.serviceMessage.getMessage("INVALID_ENTRIES_EMAIL"));
        }
    }

    private void validateRequiredFields(final Object object, final List<MessageInfo> errorList,
                                        final IMessage message) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        for (final ConstraintViolation<Object> constraintViolation : constraintViolations) {
            final MessageInfo mensagem = message.getMessageInfo(constraintViolation.getMessage());
            errorList.add(mensagem);
        }
    }
}
