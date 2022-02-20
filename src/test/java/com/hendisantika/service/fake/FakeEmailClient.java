package com.hendisantika.service.fake;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.dto.EmailResponseDTO;
import com.hendisantika.exception.EmailConnectionException;
import com.hendisantika.service.EmailClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 19.08
 * To change this template use File | Settings | File Templates.
 */
@Component
@Primary
public class FakeEmailClient implements EmailClientComponent {

    @Autowired
    private FakeEmailServer fakeEmailServer;

    @Override
    public EmailResponseDTO send(EmailRequestDTO request) throws EmailConnectionException {
        try {
            return fakeEmailServer.send(request);
        } catch (Exception e) {
            throw new EmailConnectionException(e);
        }
    }
}
