package com.anshuit.rekroot.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class GlobalConfig {
    @Bean
    @Description("ModelMapper bean")
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
