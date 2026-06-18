package com.anshuit.rekroot.configs;

import com.anshuit.rekroot.controllers.CompanyController;
import com.anshuit.rekroot.controllers.ContactController;
import com.anshuit.rekroot.controllers.JobController;
import com.anshuit.rekroot.controllers.TestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", controllerClass -> {
            Set<Class<?>> controllers = Set.of(
                    CompanyController.class,
                    JobController.class,
                    ContactController.class,
                    TestController.class
            );
            return controllers.contains(controllerClass);
        });
    }

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.com.anshuit.rekroot+json"), "v")
                .addSupportedVersions("v1", "v2")
                .setDefaultVersion("v1");
    }
}
