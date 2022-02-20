package com.hendisantika.service;

import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.stereotype.Service;

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

@Service("templateService")
public class TemplateService {

    private final MustacheAutoConfiguration mustacheAutoConfiguration;

    public TemplateService(MustacheAutoConfiguration mustacheAutoConfiguration) {
        this.mustacheAutoConfiguration = mustacheAutoConfiguration;
    }
}
