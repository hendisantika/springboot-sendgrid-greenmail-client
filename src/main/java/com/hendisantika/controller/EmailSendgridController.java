package com.hendisantika.controller;

import com.hendisantika.service.EmailService;
import com.hendisantika.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 18.55
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/send")
public class EmailSendgridController {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private EmailService emailService;
}
