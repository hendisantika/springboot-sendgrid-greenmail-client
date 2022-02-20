package com.hendisantika.service;

import com.samskivert.mustache.Template;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-sendgrid-greenmail-client
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/02/22
 * Time: 19.05
 * To change this template use File | Settings | File Templates.
 */
public class TemplateServiceTest {
    @InjectMocks
    private TemplateService service;

    @Mock
    private MustacheAutoConfiguration mustacheAutoConfiguration;

    @Mock
    private MustacheResourceTemplateLoader loader;

    @Mock
    private Compiler mustacheCompiler;

    @Mock
    private Template compile;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
