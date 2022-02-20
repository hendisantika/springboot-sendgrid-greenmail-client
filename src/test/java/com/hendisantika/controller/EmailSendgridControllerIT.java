package com.hendisantika.controller;

import com.hendisantika.base.EmailBaseIT;
import com.hendisantika.service.fake.FakeEmailServer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/02/22
 * Time: 06.21
 * To change this template use File | Settings | File Templates.
 */
public class EmailSendgridControllerIT extends EmailBaseIT {

    @Autowired
    private FakeEmailServer fakeEmailServer;

}
