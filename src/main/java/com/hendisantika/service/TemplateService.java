package com.hendisantika.service;

import com.hendisantika.dto.EmailRequestDTO;
import com.hendisantika.exception.TemplateException;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.MustacheException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.Reader;

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
    @Autowired
    private Environment environment;

    private final MustacheAutoConfiguration mustacheAutoConfiguration;

    public TemplateService(MustacheAutoConfiguration mustacheAutoConfiguration) {
        this.mustacheAutoConfiguration = mustacheAutoConfiguration;
    }

    public @NonNull
    String parseTemplateParams(EmailRequestDTO email) throws TemplateException {
        try {
            MustacheResourceTemplateLoader templateLoader = mustacheAutoConfiguration.mustacheTemplateLoader();
            Reader template = templateLoader.getTemplate(email.getTemplateName());
            return mustacheAutoConfiguration.mustacheCompiler(templateLoader)
                    .compile(template)
                    .execute(email.getTemplateParams());
        } catch (FileNotFoundException e) {
            throw new TemplateException("TEMPLATE_NOT_FOUND");
        } catch (MustacheException e) {
            throw new TemplateException("TEMPLATE_PARSE_ERROR", e);
        } catch (Exception e) {
            throw new TemplateException("GENERIC_ERROR", e);
        }
    }

    @Bean
    public Mustache.Compiler mustacheCompiler(
            Mustache.TemplateLoader templateLoader,
            Environment environment) {

        MustacheEnvironmentCollector collector
                = new MustacheEnvironmentCollector();
        collector.setEnvironment(environment);

        return Mustache.compiler()
                .defaultValue("Some Default Value")
                .withLoader(templateLoader)
                .withCollector(collector);
    }
}
