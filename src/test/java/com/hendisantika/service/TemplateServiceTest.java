package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.exception.TemplateException;
import com.samskivert.mustache.Template;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void whenParseTemplateParamsThenReturnParsedTemplateString() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Bob");
        params.put("email", "user.test@mail.com");

        EmailRequestDTO email = EmailRequestDTO.EmailRequestBuilder.of()
                .to("user.test@mail.com")
                .from("server@mail.com")
                .subject("E-mail template test")
                .templateName("email-demo-template")
                .templateParams(params)
                .build();

        mockDependenciesMustache(email);

        String parseTemplateParams = service.parseTemplateParams(email);
        assertThat(parseTemplateParams).isEqualTo(getTemplateString("result-email-demo-template"));
        assertThat(parseTemplateParams).contains(params.get("name"));
        assertThat(parseTemplateParams).contains(params.get("email"));
    }

    private static Reader getConfirmationTemplateString() throws TemplateException, IOException {
        return new FileReader(new File("src/main/resources/templates/email-demo-template.html"));
    }

    public static String getTemplateString(String templateName) throws TemplateException, IOException {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/templates/" + templateName + ".html")));
        } catch (NoSuchFileException e) {
            throw new TemplateException(e.getMessage(), e);
        }
    }
}
