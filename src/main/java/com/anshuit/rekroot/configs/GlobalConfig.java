package com.anshuit.rekroot.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class GlobalConfig {
    @Bean
    @Description("ModelMapper bean")
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "auditorAware")
    AuditorAware auditorAware(){
        return new AuditorAwareImpl();
    }
}
