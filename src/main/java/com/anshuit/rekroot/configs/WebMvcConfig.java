package com.anshuit.rekroot.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        //NOTE : Uncomment one by one to test it.

        //Below is for path versioning
        //configurer.usePathSegment(1).addSupportedVersions("v1", "v2");

        //Below is for query parameter versioning
        //configurer.useQueryParam("version").addSupportedVersions("v3", "v4");

        //Below is for request header versioning
        configurer.useRequestHeader("X-API-VERSION").addSupportedVersions("v5", "v6");

        //Below is for MIME Type versioning
        //configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.com.anshuit.rekroot+json"), "v").addSupportedVersions("v7", "v8");
    }
}
