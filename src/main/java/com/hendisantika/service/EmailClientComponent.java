package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.hendisantika.exception.EmailConnectionException;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 07.02
 * To change this template use File | Settings | File Templates.
 */
@Component
public interface EmailClientComponent {

    EmailResponseDTO send(EmailRequestDTO request) throws EmailConnectionException;
}
